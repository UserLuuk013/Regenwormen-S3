package regenwormenshared.Models;

import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Dice> takenDices;
    private List<Dice> thrownDices;

    public Round(){
        takenDices = new ArrayList<>();
        thrownDices = new ArrayList<>();
    }

    public RollDiceResult RollDice(int numberOfDices) {
        DiceThrow diceThrow = new DiceThrow();
        this.thrownDices = diceThrow.GenerateDiceThrow(numberOfDices);
        return new RollDiceResult(thrownDices);
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
            this.takenDices = setAsideResult.getTakenDices();
//            rollDiceResult.getThrownDices().removeAll(chosenDices);
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

    public List<Dice> getTakenDices() {
        return takenDices;
    }

    public List<Dice> getThrownDices() {
        return thrownDices;
    }
}
