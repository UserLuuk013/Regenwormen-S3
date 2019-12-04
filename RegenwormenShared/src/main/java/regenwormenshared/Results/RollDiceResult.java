package regenwormenshared.Results;

import regenwormenshared.Models.Dice;

import java.util.List;

public class RollDiceResult implements GameResult {
    private List<Dice> thrownDices;

    public RollDiceResult(List<Dice> thrownDices){
        this.thrownDices = thrownDices;
    }

    public List<Dice> getThrownDices() {
        return thrownDices;
    }

    public void setThrownDices(List<Dice> thrownDices) {
        this.thrownDices = thrownDices;
    }
}
