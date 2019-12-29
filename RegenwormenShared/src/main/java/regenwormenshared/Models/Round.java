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

    public RollDiceResult RollDice(int numberOfDices) {
        DiceThrow diceThrow = new DiceThrow();
        return new RollDiceResult(diceThrow.GenerateDiceThrow(numberOfDices));
    }

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
        }
        return setAsideResult;
    }

    public boolean CheckIfDiceMayBePutAside(List<Dice> takenDices, Dice chosenDice) {
        return !takenDices.contains(chosenDice);
    }

    public boolean EndRound() {
        return true;
    }

    public TakeTileResult TakeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult){
        int value = 0;
        for (Dice dice : setAsideResult.getTakenDices()){
            value += dice.getValue();
        }
        for (Dice dice : setAsideResult.getTakenDices()){
            if (value >= takeTileResult.getChosenTile().getValue() && dice.getRegenworm()){
                for (Tile tile : takeTileResult.getChosenStackOrRow()){
                    if (tile.getValue() == takeTileResult.getChosenTile().getValue()){
                        takeTileResult.getChosenStackOrRow().remove(tile);
                        takeTileResult.getStack().add(tile);
                        break;
                    }
                }
            }
        }
        return takeTileResult;
    }

    public ReturnTileResult ReturnTile(ReturnTileResult returnTileResult){
        Tile tile = returnTileResult.getStack().get(0);
        Tile tileRow = returnTileResult.getRow().get(returnTileResult.getRow().size() - 1);

        if (tile.getValue() < tileRow.getValue()){
            tile.setVisible(false);
        }

        returnTileResult.getStack().remove(tile);
        returnTileResult.getRow().add(tile);

        return returnTileResult;
    }
}
