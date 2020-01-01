package regenwormenclient;

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

    IClientMessageGenerator messageGenerator;

    public GameClient(IClientMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
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
    public void rollDice(int numberOfDices) {
        this.messageGenerator.throwDices(numberOfDices);
    }

    @Override
    public void setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        this.messageGenerator.setAside(rollDiceResult, setAsideResult);
    }

    @Override
    public void takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        this.messageGenerator.takeTile(setAsideResult, takeTileResult);
    }

    @Override
    public void returnTile(ReturnTileResult returnTileResult) {
        this.messageGenerator.returnTile(returnTileResult);
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
        System.out.println("The result of registering by Player " + sessionId + " is:");
        System.out.println(result);
    }

    @Override
    public void processLoginPlayerResult(String sessionId, Player player) {
        System.out.println("The name of Player " + sessionId + " who logged in is:");
        System.out.println(player.getUsername());
        System.out.println(player.getPassword());
    }

    @Override
    public void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult) {
        System.out.println("The result of the thrown dices by Player " + sessionId + " is:");
        for(Dice dice : rollDiceResult.getThrownDices()){
            System.out.println(dice.getValue() + " " + dice.getRegenworm());
        }
    }

    @Override
    public void processSetAsideResult(String sessionId, SetAsideResult setAsideResult) {
        System.out.println("All of the set aside dices by Player " + sessionId + " are:");
        for(Dice dice : setAsideResult.getTakenDices()){
            System.out.println(dice.getValue() + " " + dice.getRegenworm());
        }
    }

    @Override
    public void processTakeTileResult(String sessionId, TakeTileResult takeTileResult) {
        System.out.println("The stack of Player " + sessionId + " after taking Tile " + takeTileResult.getChosenTile().getValue());
        for (Tile tile : takeTileResult.getStack()){
            System.out.println(tile.getValue());
        }
        System.out.println("The row of the Game after taking Tile " + takeTileResult.getChosenTile().getValue());
        for (Tile tile : takeTileResult.getChosenStackOrRow()){
            System.out.println(tile.getValue());
        }
    }

    @Override
    public void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult) {
        System.out.println("The stack of Player " + sessionId + " after returning his tile");
        for (Tile tile : returnTileResult.getStack()){
            System.out.println(tile.getValue());
        }
        System.out.println("The row of the Game after return Player " + sessionId + " his tile");
        for (Tile tile : returnTileResult.getRow()){
            System.out.println(tile.getValue());
        }
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
}
