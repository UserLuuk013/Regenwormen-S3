package regenwormenclient;

import regenwormenshared.Messaging.Client.IClientGUI;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.List;

public class TestClientGUI implements IClientGUI {
    private IGameClient gameClient;

    public TestClientGUI(IGameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void processRegisterPlayerResult(String sessionId, boolean result) {
        System.out.println("The result of registering by Player " + sessionId + " is:");
        System.out.println(result);
    }

    @Override
    public void processLoginPlayerResult(String sessionId, Player player) {
        System.out.println("Logged in by " + player.getUsername());
        System.out.println("Waiting for opponent...");
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
    public void processEndRollDiceResult(String sessionId, boolean result) {
        if(result){
            System.out.println("Player " + sessionId + " is allowed to end rolling dices.");
        }
        else{
            System.out.println("Player " + sessionId + " is not allowed to end rolling dices.");
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
    public void processNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row) {
        System.out.println("New round has started");
        System.out.println("----- Row -----");
        for (Tile tile : row){
            System.out.println(tile.getValue() + " " + tile.getAmountOfRegenwormen() + " " + tile.getVisible());
        }
        System.out.println("---------------");

        System.out.println("--- " + player1.getUsername() + " ---");
        if (player1.getStack().size() != 0){
            System.out.println(player1.getStack().get(player1.getStack().size() - 1).getValue());
        }
        else{
            System.out.println("- Empty Stack -");
        }

        System.out.println("--- " + player2.getUsername() + " ---");
        if (player2.getStack().size() != 0){
            System.out.println(player2.getStack().get(player2.getStack().size() - 1).getValue());
        }
        else{
            System.out.println("- Empty Stack -");
        }

        if (player1.isHasTurn()){
            System.out.println(player1.getUsername() + " has turn");
        }
        else{
            System.out.println(player2.getUsername() + " has turn");
        }
    }

    @Override
    public void processGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw) {
        System.out.println("Game Ended");
        if (scorePlayer1 > scorePlayer2 && !draw){
            System.out.println("Player 1 has won the game with a score of " + scorePlayer1);
            System.out.println("Player 2 has lost the game with a score of " + scorePlayer2);
        }
        else if (scorePlayer1 < scorePlayer2 && !draw){
            System.out.println("Player 2 has won the game with a score of " + scorePlayer2);
            System.out.println("Player 1 has lost the game with a score of " + scorePlayer1);
        }
        else if (draw){
            System.out.println("Game ended in a draw.");
            System.out.println("Player 1 ended the game with a score of " + scorePlayer1);
            System.out.println("Player 2 ended the game with a score of " + scorePlayer2);
        }
    }

    @Override
    public void processPlayerJoined(String sessionId, Player player) {
        System.out.println("Another player has joined the game.");
        System.out.println("Your opponent is: " + player.getUsername());
    }
}
