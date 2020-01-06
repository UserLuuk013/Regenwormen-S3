package regenwormenclient;

import regenwormenshared.Messaging.Client.IClientGUI;
import regenwormenshared.Messaging.Client.IClientMessageGenerator;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
import regenwormenshared.Models.Enums.GameWarning;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.List;

public class GameClient implements IGameClient {

    private IClientMessageGenerator messageGenerator;
    private IClientGUI clientGUI;

    public GameClient(IClientMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }


    @Override
    public void registerClientGUI(IClientGUI clientGUI) {
        this.clientGUI = clientGUI;
    }

    @Override
    public void registerPlayer(String username, String password) {
        this.messageGenerator.registerPlayer(username, password);
    }

    @Override
    public void loginPlayer(String username, String password) {
        this.messageGenerator.loginPlayer(username, password);
    }

    @Override
    public void rollDice() {
        this.messageGenerator.rollDice();
    }

    @Override
    public void setAside(Dice chosenDice) {
        this.messageGenerator.setAside(chosenDice);
    }

    @Override
    public void endRollDice() {
        this.messageGenerator.endRollDice();
    }

    @Override
    public void takeTile(Tile chosenTile) {
        this.messageGenerator.takeTile(chosenTile);
    }

    @Override
    public void returnTile() {
        this.messageGenerator.returnTile();
    }

    @Override
    public void getAllTiles() {
        this.messageGenerator.getAllTiles();
    }

    @Override
    public void getAllDices() {
        this.messageGenerator.getAllDices();
    }

    @Override
    public void processRegisterPlayerResult(String sessionId, boolean result) {
        this.clientGUI.processRegisterPlayerResult(sessionId, result);
    }

    @Override
    public void processLoginPlayerResult(String sessionId, Player player) {
        this.clientGUI.processLoginPlayerResult(sessionId, player);
    }

    @Override
    public void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult) {
        this.clientGUI.processRollDiceResult(sessionId, rollDiceResult);
    }

    @Override
    public void processSetAsideResult(String sessionId, SetAsideResult setAsideResult) {
        this.clientGUI.processSetAsideResult(sessionId, setAsideResult);
    }

    @Override
    public void processEndRollDiceResult(String sessionId, boolean result) {
        this.clientGUI.processEndRollDiceResult(sessionId, result);
    }

    @Override
    public void processTakeTileResult(String sessionId, TakeTileResult takeTileResult) {
        this.clientGUI.processTakeTileResult(sessionId, takeTileResult);
    }

    @Override
    public void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult) {
        this.clientGUI.processReturnTileResult(sessionId, returnTileResult);
    }

    @Override
    public void processNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row) {
        this.clientGUI.processNewRoundStarted(sessionId, player1, player2, row);
    }

    @Override
    public void processGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw) {
        this.clientGUI.processGameEndedResult(sessionId, scorePlayer1, scorePlayer2, draw);
    }

    @Override
    public void processGetAllTilesResult(String sessionId, List<Tile> tiles) {
        System.out.println("The list of Tiles after calling query by Player " + sessionId + " looks like this:");
        for (Tile tile : tiles){
            System.out.println(tile.getValue());
        }
    }

    @Override
    public void processGetAllDicesResult(String sessionId, List<Dice> dices) {
        System.out.println("The list of Dices after calling query by Player " + sessionId + " looks like this:");
        for (Dice dice : dices){
            System.out.println(dice.getValue() + " " + dice.getRegenworm());
        }
    }

    @Override
    public void processPlayerJoined(String sessionId, Player player) {
        this.clientGUI.processPlayerJoined(sessionId, player);
    }

    @Override
    public void processErrorGameStateMessage(String sessionId, GameState gameState) {
        this.clientGUI.processErrorGameStateMessage(sessionId, gameState);
    }

    @Override
    public void processGameWarningMessage(String sessionId, GameWarning gameWarning) {
        this.clientGUI.processGameWarningMessage(sessionId, gameWarning);
    }
}
