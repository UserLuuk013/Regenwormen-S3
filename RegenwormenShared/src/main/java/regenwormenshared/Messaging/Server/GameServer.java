package regenwormenshared.Messaging.Server;

import regenwormenshared.Converters.DiceDTOModelConverter;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
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
        Player player = playerConverter.ModelFromDTO(playerDTO);
        messageGenerator.notifyLoginPlayerResult(sessionId, player);

        if (player1 == null){
            player1 = player;
            player1.setHasTurn(true);
            joinGame(sessionId, player1.getUsername());
        }
        else if (player2 == null){
            player2 = player;
            player2.setHasTurn(false);
            joinGame(sessionId, player2.getUsername());
            setupGame();
        }
    }

    @Override
    public void rollDice(String sessionId, int numberOfDices) {
        //Change method by deleting numberOfDices
        currentRound = new Round();
        gameState = GameState.ROLLDICE;
        this.rollDiceResult = currentRound.RollDice(8 - currentRound.getTakenDices().size());
        messageGenerator.notifyRollDiceResult(sessionId, rollDiceResult);
    }

    @Override
    public void setAside(String sessionId, RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        //Change method by deleting rollDiceResult and setAsideResult. Only (value of) chosenDice is needed
        Dice chosenDice = new Dice(1, "image.jpg", false);
        gameState = GameState.SETASIDE;
        this.setAsideResult = currentRound.SetAside(rollDiceResult, new SetAsideResult(currentRound.getTakenDices(), chosenDice));
        messageGenerator.notifySetAsideResult(sessionId, setAsideResult);
    }

    @Override
    public void endRollDice(String sessionId) {
        gameState = GameState.ENDROLLDICE;

        int value = 0;
        boolean endRollDice = false;

        for (Dice dice : currentRound.getTakenDices()){
            value += dice.getValue();
        }

        for (Tile tile : row){
            if (tile.getVisible() && tile.getValue() >= value){
                endRollDice = true;
            }
        }

        for (Tile tile : getPlayerByTurn(false).getStack()){
            if (tile.getVisible() && tile.getValue() >= value){
                endRollDice = true;
            }
        }

        if (endRollDice){
            //messageGenerator.notifyRollDiceEnded(String sessionId);
        }
        else{
            //messageGenerator.notifyRollDiceNotEnded(String sessionId);
        }
    }

    @Override
    public void takeTile(String sessionId, SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        //Change method by deleting setAsideResult and takeTileResult. Only chosenTile is needed.
        Tile chosenTile = new Tile(21, "image.jpg", 1);
        gameState = GameState.TAKETILE;
        for (Tile tile : row){
            if (tile.getValue() == chosenTile.getValue() && tile.getVisible()){
                this.takeTileResult = currentRound.TakeTile(setAsideResult, new TakeTileResult(chosenTile, row, getPlayerByTurn(true).getStack()));
            }
        }

        for (Tile tile : getPlayerByTurn(false).getStack()){
            if (tile.getValue() == chosenTile.getValue() && tile.getVisible()){
                this.takeTileResult = currentRound.TakeTile(setAsideResult, new TakeTileResult(chosenTile, getPlayerByTurn(false).getStack(), getPlayerByTurn(true).getStack()));
            }
        }
        messageGenerator.notifyTakeTileResult(sessionId, takeTileResult);
        roundEnded();
    }

    @Override
    public void returnTile(String sessionId, ReturnTileResult returnTileResult) {
        //Change method by deleting returnTileResult.
        gameState = GameState.RETURNTILE;
        this.returnTileResult = currentRound.ReturnTile(new ReturnTileResult(row, getPlayerByTurn(true).getStack()));
        messageGenerator.notifyReturnTileResult(sessionId, returnTileResult);
        roundEnded();
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

    }

    @Override
    public void joinGame(String sessionId, String username) {
        //messageGenerator.notifyPlayerJoined(sessionId, username);
    }

    @Override
    public void startNewRound() {
        this.currentRound = new Round();
        if (roundCounter != 0){
            swapTurns();
        }
        roundCounter += 1;
        //messageGenerator.notifyNewRoundStarted(player1.isHasTurn(), player2.isHasTurn());
    }

    @Override
    public void roundEnded() {
        gameState = GameState.ENDROUND;
        checkGame();
    }

    @Override
    public void setupGame() {
        row = new ArrayList<>();
        for (int i = 21; i < 36; i++){
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
        startNewRound();
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
    public void checkGame() {
        gameState = GameState.CHECKGAME;
        for (Tile tile : row){
            if (row.size() == 0 || !tile.getVisible()){
                gameEnded();
            }
            else{
                startNewRound();
            }
        }
    }

    @Override
    public void gameEnded() {
        int scorePlayer1 = 0;
        int scorePlayer2 = 0;


        for (Tile tile : player1.getStack()){
            scorePlayer1 += tile.getAmountOfRegenwormen();
        }

        for (Tile tile : player2.getStack()){
            scorePlayer2 += tile.getAmountOfRegenwormen();
        }

        if (scorePlayer1 > scorePlayer2){
            //messageGenerator.notifyGameEnded(scorePlayer1, scorePlayer2);
        }
        else if (scorePlayer2 > scorePlayer1){
            //messageGenerator.notifyGameEnded(scorePlayer2, scorePlayer1);
        }
        else{
            //messageGenerator.notifyGameEndedDraw(scorePlayer1, scorePlayer2);
        }
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
