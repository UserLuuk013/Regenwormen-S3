package regenwormenshared.Results;

import regenwormenshared.Models.Dice;

import java.util.List;

public class SetAsideResult implements GameResult {
    private List<Dice> takenDices;
    private Dice chosenDice;

    public SetAsideResult(List<Dice> takenDices, Dice chosenDice){
        this.takenDices = takenDices;
        this.chosenDice = chosenDice;
    }

    public List<Dice> getTakenDices() {
        return takenDices;
    }

    public void setTakenDices(List<Dice> takenDices) {
        this.takenDices = takenDices;
    }

    public Dice getChosenDice() {
        return chosenDice;
    }

    public void setChosenDice(Dice chosenDice) {
        this.chosenDice = chosenDice;
    }
}
