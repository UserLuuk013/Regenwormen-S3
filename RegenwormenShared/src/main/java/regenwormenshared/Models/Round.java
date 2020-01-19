package regenwormenshared.models;

import regenwormenshared.results.ReturnTileResult;
import regenwormenshared.results.RollDiceResult;
import regenwormenshared.results.SetAsideResult;
import regenwormenshared.results.TakeTileResult;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private List<Dice> takenDices;
    private List<Dice> thrownDices;

    public Round(){
        takenDices = new ArrayList<>();
        thrownDices = new ArrayList<>();
    }

    public RollDiceResult rollDice(int numberOfDices) {
        DiceThrow diceThrow = new DiceThrow();
        this.thrownDices = diceThrow.generateDiceThrow(numberOfDices);
        return new RollDiceResult(thrownDices);
    }

    public SetAsideResult setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        List<Dice> chosenDices = new ArrayList<>();

        if (checkIfDiceMayBePutAside(setAsideResult.getTakenDices(), setAsideResult.getChosenDice())) {
            for (Dice thrownDice : rollDiceResult.getThrownDices()){
                if (thrownDice.getValue() == setAsideResult.getChosenDice().getValue() && thrownDice.isRegenworm() == setAsideResult.getChosenDice().isRegenworm()){
                    chosenDices.add(thrownDice);
                }
            }
            setAsideResult.getTakenDices().addAll(chosenDices);
            this.takenDices = setAsideResult.getTakenDices();
        }
        return setAsideResult;
    }

    public boolean checkIfDiceMayBePutAside(List<Dice> takenDices, Dice chosenDice) {
        return !takenDices.contains(chosenDice);
    }

    public boolean endRound() {
        return true;
    }

    public TakeTileResult takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult){
        int value = 0;
        boolean isTileTaken = false;
        for (Dice dice : setAsideResult.getTakenDices()){
            value += dice.getValue();
        }
        for (Dice dice : setAsideResult.getTakenDices()){
            if (!isTileTaken && value >= takeTileResult.getChosenTile().getValue() && dice.isRegenworm()){
                for (Tile tile : takeTileResult.getChosenStackOrRow()){
                    if (tile.getValue() == takeTileResult.getChosenTile().getValue()){
                        takeTileResult.getChosenStackOrRow().remove(tile);
                        takeTileResult.getStack().add(tile);
                        isTileTaken = true;
                        break;
                    }
                }
            }
        }
        return takeTileResult;
    }

    public ReturnTileResult returnTile(ReturnTileResult returnTileResult){
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
