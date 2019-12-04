package regenwormenshared.Models;

import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Tile> row;
    private List<Player> players;
    private boolean singlePlayer;
    private String turn;
    private List<Dice> thrownDices;
    private List<Dice> takenDices;

    public Round(List<Tile> row, List<Player> players, boolean singlePlayer, String turn,
                 List<Dice> thrownDices, List<Dice> takenDices){
        this.row = row;
        this.players = players;
        this.singlePlayer = singlePlayer;
        this.turn = turn;
        this.thrownDices = thrownDices;
        this.takenDices = takenDices;
    }

    public Round(){

    }

//    public List<Dice> RollDice(int numberOfDices) {
//        DiceThrow diceThrow = new DiceThrow();
//        return diceThrow.GenerateDiceThrow(numberOfDices);
//    }

    public RollDiceResult RollDice(int numberOfDices) {
        DiceThrow diceThrow = new DiceThrow();
        return new RollDiceResult(diceThrow.GenerateDiceThrow(numberOfDices));
    }

//    public List<Dice> SetAside(List<Dice> thrownDices, List<Dice> takenDices, Dice chosenDice) {
//        List<Dice> chosenDices = new ArrayList<>();
//        if (CheckIfDiceMayBePutAside(takenDices, chosenDice)){
//            for (Dice thrownDice : thrownDices){
//                if (thrownDice.getValue() == chosenDice.getValue() && thrownDice.getRegenworm() == chosenDice.getRegenworm()){
//                    chosenDices.add(thrownDice);
//                }
//            }
//            takenDices.addAll(chosenDices);
//            thrownDices.removeAll(chosenDices);
//        }
//        return thrownDices;
//        // Returning multiple items -> Class?
//    }

    public SetAsideResult SetAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        List<Dice> chosenDices = new ArrayList<>();

        if (CheckIfDiceMayBePutAside(setAsideResult.getTakenDices(), setAsideResult.getChosenDice())) {
            for (Dice thrownDice : rollDiceResult.getThrownDices()){
                if (thrownDice.getValue() == setAsideResult.getChosenDice().getValue() && thrownDice.getRegenworm() == setAsideResult.getChosenDice().getRegenworm()){
                    chosenDices.add(thrownDice);
                }
            }
            setAsideResult.getTakenDices().addAll(chosenDices);
            rollDiceResult.getThrownDices().removeAll(chosenDices);

            setAsideResult.setTakenDices(setAsideResult.getTakenDices());
            rollDiceResult.setThrownDices(rollDiceResult.getThrownDices());
        }
        return setAsideResult;
    }

    public boolean CheckIfDiceMayBePutAside(List<Dice> takenDices, Dice chosenDice) {
        if (!takenDices.contains(chosenDice)){
            return true;
        }
        return false;
    }

    public boolean EndRound() {
        return true;
    }

//    public boolean TakeTile(List<Dice> thrownDices, Tile chosenTile, List<Tile> chosenStackOrRow, List<Tile> stack) {
//        int value = 0;
//        for (Dice dice : thrownDices){
//            value += dice.getValue();
//        }
//        for (Dice dice : thrownDices){
//            if (value >= chosenTile.getValue() && dice.getRegenworm()){
//                chosenStackOrRow.remove(chosenTile);
//                stack.add(chosenTile);
//                return true;
//            }
//        }
//        return false;
//        // Returning multiple items -> Class?
//    }

    public TakeTileResult TakeTile(RollDiceResult rollDiceResult, TakeTileResult takeTileResult){
        int value = 0;
        for (Dice dice : rollDiceResult.getThrownDices()){
            value += dice.getValue();
        }
        for (Dice dice : rollDiceResult.getThrownDices()){
            if (value >= takeTileResult.getChosenTile().getValue() && dice.getRegenworm()){
                takeTileResult.getChosenStackOrRow().remove(takeTileResult.getChosenTile());
                takeTileResult.getStack().add(takeTileResult.getChosenTile());

                takeTileResult.setChosenStackOrRow(takeTileResult.getChosenStackOrRow());
                takeTileResult.setStack(takeTileResult.getStack());
            }
        }
        return takeTileResult;
    }

//    public List<Tile> ReturnTile(List<Tile> row, List<Tile> stack) {
//        Tile tile = stack.get(0);
//        if ((row.size() - 1) != tile.getValue()){
//            tile.setVisible(false);
//        }
//        stack.remove(tile);
//        row.add(tile);
//        return row;
//        // Returning multiple items -> Class?
//    }

    public ReturnTileResult ReturnTile(ReturnTileResult returnTileResult){
        Tile tile = returnTileResult.getStack().get(0);
        List<Tile> stack = returnTileResult.getStack();
        List<Tile> row = returnTileResult.getRow();

        if ((returnTileResult.getRow().size() - 1) != tile.getValue()){
            tile.setVisible(false);
        }

        stack.remove(tile);
        row.add(tile);

        returnTileResult.setStack(stack);
        returnTileResult.setRow(row);

        return returnTileResult;
    }
}
