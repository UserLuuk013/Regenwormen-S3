package regenwormenshared.Messaging.Server;

import regenwormenshared.Converters.DiceDTOModelConverter;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Messaging.Server.IGameServer;
import regenwormenshared.Messaging.Server.IServerMessageGenerator;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
import regenwormenshared.Models.Enums.GameWarning;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Round;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
import restclient.RestClient;

import java.util.ArrayList;
import java.util.List;

public class GameServer implements IGameServer {

    private Round currentRound;
    private RestClient restClient;
    private IServerMessageGenerator messageGenerator;

    private Player player1;
    private Player player2;
    private GameState gameState;
    private int roundCounter;

    private List<Tile> row;
    private RollDiceResult rollDiceResult;
    private SetAsideResult setAsideResult;
    private TakeTileResult takeTileResult;
    private ReturnTileResult returnTileResult;

    public GameServer(IServerMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
        this.restClient = new RestClient();
    }

    @Override
    public void registerPlayer(String sessionId, String username, String password) {
        boolean result = restClient.playerRegister(username, password);
        messageGenerator.notifyRegisterPlayerResult(sessionId, result);
    }

    @Override
    public void loginPlayer(String sessionId, String username, String password) {
        PlayerDTOModelConverter playerConverter = new PlayerDTOModelConverter();

        PlayerDTO playerDTO = restClient.playerLogin(username, password);

        if (playerDTO != null){
            Player player = playerConverter.ModelFromDTO(playerDTO);
            messageGenerator.notifyLoginPlayerResult(sessionId, player);

            if (player1 == null){
                player1 = player;
                player1.setHasTurn(true);
                joinGame(sessionId, player1);
            }
            else if (player2 == null){
                player2 = player;
                player2.setHasTurn(false);
                joinGame(sessionId, player2);
                setupGame(sessionId);
            }
        }
        else{
            messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.LOGINFAILED);
        }
    }

    @Override
    public void rollDice(String sessionId) {
        if (gameState == GameState.ROLLDICE){
            if (currentRound.getTakenDices().size() != 8){
                this.rollDiceResult = currentRound.RollDice(8 - currentRound.getTakenDices().size());

                if (isAllInList()) {
                    this.gameState = GameState.RETURNTILE;
                    messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.ROLLDICE);
                    returnTile(sessionId);
                }
                else{
                    this.gameState = GameState.SETASIDE;
                    messageGenerator.notifyRollDiceResult(sessionId, rollDiceResult);
                }
            }
            else{
                messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.ROLLDICENOTALLOWED);
                endRollDice(sessionId);
            }
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }
    }

    public boolean isAllInList() {
        boolean allInList = true;
        for (Dice thrownDice : rollDiceResult.getThrownDices()){
            if (!currentRound.getTakenDices().contains(thrownDice)) {
                allInList = false;
                break;
            }
        }
        return allInList;
    }

    @Override
    public void setAside(String sessionId, Dice chosenDice) {
        if (gameState == GameState.SETASIDE){
            if (!currentRound.getTakenDices().contains(chosenDice)){
                this.setAsideResult = currentRound.SetAside(rollDiceResult, new SetAsideResult(currentRound.getTakenDices(), chosenDice));
                this.gameState = GameState.ROLLDICE;
                messageGenerator.notifySetAsideResult(sessionId, setAsideResult);
            }
            else{
                messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.SETASIDE);
            }
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }
    }

    @Override
    public void endRollDice(String sessionId) {
        this.gameState = GameState.ENDROLLDICE;

        boolean endRollDice = checkEndRollDice();
        if (endRollDice){
            this.gameState = GameState.TAKETILE;
        }
        else{
            if (currentRound.getTakenDices().size() != 8){
                this.gameState = GameState.ROLLDICE;
            }
            else{
                this.gameState = GameState.RETURNTILE;
                messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.ENDROLLDICE);
                returnTile(sessionId);
            }

        }
        messageGenerator.notifyEndRollDiceResult(sessionId, endRollDice);
    }

    private boolean checkEndRollDice() {
        int value = 0;
        boolean endRollDice = false;
        List<Tile> stackOpponent = getPlayerByTurn(false).getStack();

        for (Dice dice : currentRound.getTakenDices()){
            value += dice.getValue();
        }

        for (Tile tile : row){
            if (tile.isVisible() && value >= tile.getValue()) {
                endRollDice = true;
                break;
            }
        }

        if (!endRollDice){
            if (stackOpponent.get(stackOpponent.size() - 1).isVisible() && value >= stackOpponent.get(stackOpponent.size() - 1).getValue()){
                endRollDice = true;
            }
        }
        return endRollDice;
    }

    @Override
    public void takeTile(String sessionId, Tile chosenTile) {
        if (gameState == GameState.TAKETILE){
            if (row.contains(chosenTile)){
                this.takeTileResult = currentRound.TakeTile(setAsideResult, new TakeTileResult(chosenTile, row, getPlayerByTurn(true).getStack()));
                row = takeTileResult.getChosenStackOrRow();
                getPlayerByTurn(true).setStack(takeTileResult.getStack());
            }
            else if (getPlayerByTurn(false).getStack().contains(chosenTile)){
                this.takeTileResult = currentRound.TakeTile(setAsideResult, new TakeTileResult(chosenTile, getPlayerByTurn(false).getStack(), getPlayerByTurn(true).getStack()));
                getPlayerByTurn(false).setStack(takeTileResult.getChosenStackOrRow());
                getPlayerByTurn(true).setStack(takeTileResult.getStack());
            }
            else{
                messageGenerator.notifyGameWarningMessage(sessionId, GameWarning.TAKETILE);
            }
            messageGenerator.notifyTakeTileResult(sessionId, takeTileResult);
            this.gameState = GameState.ENDROUND;
            roundEnded(sessionId);
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }
    }

    @Override
    public void returnTile(String sessionId) {
        if (gameState == GameState.RETURNTILE){
            this.returnTileResult = currentRound.ReturnTile(new ReturnTileResult(row, getPlayerByTurn(true).getStack()));

            row = returnTileResult.getRow();
            getPlayerByTurn(true).setStack(returnTileResult.getStack());

            this.gameState = GameState.ENDROUND;
            messageGenerator.notifyReturnTileResult(sessionId, returnTileResult);
            roundEnded(sessionId);
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }

    }

    @Override
    public void roundEnded(String sessionId) {
        if (gameState == GameState.ENDROUND){
            gameState = GameState.CHECKGAME;
            checkGame(sessionId);
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }
    }

    @Override
    public void checkGame(String sessionId) {
        if (gameState == GameState.CHECKGAME){
            boolean gameEnded = false;
            int tileCounter = 0;

            if (row.size() != 0){
                for (Tile tile : row){
                    if (!tile.isVisible()){
                        tileCounter++;
                    }
                }

                if (tileCounter == row.size()){
                    gameEnded = true;
                }
            }
            else{
                gameEnded = true;
            }

            if (gameEnded){
                gameEnded(sessionId);
            }
            else{
                startNewRound(sessionId);
            }
        }
        else{
            messageGenerator.notifyErrorGameState(sessionId, gameState);
        }
    }

    @Override
    public void gameEnded(String sessionId) {
        int scorePlayer1 = 0;
        int scorePlayer2 = 0;


        for (Tile tile : player1.getStack()){
            scorePlayer1 += tile.getAmountOfRegenwormen();
        }

        for (Tile tile : player2.getStack()){
            scorePlayer2 += tile.getAmountOfRegenwormen();
        }

        if (scorePlayer1 != scorePlayer2){
            messageGenerator.notifyGameEndedResult(sessionId, scorePlayer1, scorePlayer2, false);
        }
        else{
            messageGenerator.notifyGameEndedResult(sessionId, scorePlayer1, scorePlayer2, true);
        }
    }

    @Override
    public void startNewRound(String sessionId) {
        this.currentRound = new Round();
        if (roundCounter != 0){
            swapTurns();
            this.rollDiceResult = null;
            this.setAsideResult = null;
            this.takeTileResult = null;
            this.returnTileResult = null;
        }
        roundCounter += 1;
        gameState = GameState.ROLLDICE;
        messageGenerator.notifyNewRoundStarted(sessionId, player1, player2, row);
    }

    @Override
    public void swapTurns() {
        if (player1.isHasTurn()){
            player1.setHasTurn(false);
            player2.setHasTurn(true);
        }
        else{
            player1.setHasTurn(true);
            player2.setHasTurn(false);
        }
    }

    @Override
    public void getAllTiles(String sessionId) {
        TileDTOModelConverter tileConverter = new TileDTOModelConverter();

        List<Tile> tiles = new ArrayList<>();

        List<TileDTO> tileDTOs = restClient.getAllTiles();
        for (TileDTO dto : tileDTOs){
            tiles.add(tileConverter.ModelFromDTO(dto));
        }
        messageGenerator.notifyGetAllTilesResult(sessionId, tiles);
    }

    @Override
    public void getAllDices(String sessionId) {
        DiceDTOModelConverter diceConverter = new DiceDTOModelConverter();

        List<Dice> dices = new ArrayList<>();

        List<DiceDTO> diceDTOs = restClient.getAllDices();
        for (DiceDTO dto : diceDTOs){
            dices.add(diceConverter.ModelFromDTO(dto));
        }
        messageGenerator.notifyGetAllDicesResult(sessionId, dices);
    }

    @Override
    public void processClientDisconnect(String sessionId) {
        //Left to fill in
    }

    @Override
    public void joinGame(String sessionId, Player player) {
        messageGenerator.notifyPlayerJoined(sessionId, player);
    }

    @Override
    public void setupGame(String sessionId) {
        row = new ArrayList<>();
        for (int i = 21; i < 37; i++){
            if (i < 25) {
                row.add(new Tile(i, "image.jpg", 1));
            }
            else if (i < 29) {
                row.add(new Tile(i, "image.jpg", 2));
            }
            else if (i < 33){
                row.add(new Tile(i, "image.jpg", 3));
            }
            else {
                row.add(new Tile(i, "image.jpg", 4));
            }
        }
        this.roundCounter = 0;
        startNewRound(sessionId);
    }

    @Override
    public Player getPlayerByTurn(boolean hasTurn) {
        if (hasTurn == player1.isHasTurn()){
            return player1;
        }
        else{
            return player2;
        }
    }
}
