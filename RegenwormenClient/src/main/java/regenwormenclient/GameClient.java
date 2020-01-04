package regenwormenclient;

import regenwormenshared.Messaging.Client.IClientGUI;
import regenwormenshared.Messaging.Client.IClientMessageGenerator;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Models.Dice;
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
//        System.out.println("The result of registering by Player " + sessionId + " is:");
//        System.out.println(result);
        this.clientGUI.processRegisterPlayerResult(sessionId, result);
    }

    @Override
    public void processLoginPlayerResult(String sessionId, Player player) {
//        System.out.println("The name of Player " + sessionId + " who logged in is:");
//        System.out.println(player.getUsername());
//        System.out.println(player.getPassword());
        this.clientGUI.processLoginPlayerResult(sessionId, player);
    }

    @Override
    public void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult) {
//        System.out.println("The result of the thrown dices by Player " + sessionId + " is:");
//        for(Dice dice : rollDiceResult.getThrownDices()){
//            System.out.println(dice.getValue() + " " + dice.getRegenworm());
//        }
        this.clientGUI.processRollDiceResult(sessionId, rollDiceResult);
    }

    @Override
    public void processSetAsideResult(String sessionId, SetAsideResult setAsideResult) {
//        System.out.println("All of the set aside dices by Player " + sessionId + " are:");
//        for(Dice dice : setAsideResult.getTakenDices()){
//            System.out.println(dice.getValue() + " " + dice.getRegenworm());
//        }
        this.clientGUI.processSetAsideResult(sessionId, setAsideResult);
    }

    @Override
    public void processEndRollDiceResult(String sessionId, boolean result) {
        //Left to fill in
        this.clientGUI.processEndRollDiceResult(sessionId, result);
    }

    @Override
    public void processTakeTileResult(String sessionId, TakeTileResult takeTileResult) {
//        System.out.println("The stack of Player " + sessionId + " after taking Tile " + takeTileResult.getChosenTile().getValue());
//        for (Tile tile : takeTileResult.getStack()){
//            System.out.println(tile.getValue());
//        }
//        System.out.println("The row of the Game after taking Tile " + takeTileResult.getChosenTile().getValue());
//        for (Tile tile : takeTileResult.getChosenStackOrRow()){
//            System.out.println(tile.getValue());
//        }
        this.clientGUI.processTakeTileResult(sessionId, takeTileResult);
    }

    @Override
    public void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult) {
//        System.out.println("The stack of Player " + sessionId + " after returning his tile");
//        for (Tile tile : returnTileResult.getStack()){
//            System.out.println(tile.getValue());
//        }
//        System.out.println("The row of the Game after return Player " + sessionId + " his tile");
//        for (Tile tile : returnTileResult.getRow()){
//            System.out.println(tile.getValue());
//        }
        this.clientGUI.processReturnTileResult(sessionId, returnTileResult);
    }

    @Override
    public void processNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row) {
        //Left to fill in
        this.clientGUI.processNewRoundStarted(sessionId, player1, player2, row);
    }

    @Override
    public void processGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw) {
        //Left to fill in
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
        //Left to fill in
        this.clientGUI.processPlayerJoined(sessionId, player);
    }
}
