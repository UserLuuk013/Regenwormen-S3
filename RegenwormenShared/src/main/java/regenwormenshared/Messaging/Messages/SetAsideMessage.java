package regenwormenshared.Messaging.Messages;

import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;

public class SetAsideMessage {

    private RollDiceResult rollDiceResult;

    private SetAsideResult setAsideResult;

    public RollDiceResult getRollDiceResult() {
        return rollDiceResult;
    }

    public SetAsideResult getSetAsideResult() {
        return setAsideResult;
    }

    public SetAsideMessage(RollDiceResult rollDiceResult, SetAsideResult setAsideResult){
        this.rollDiceResult = rollDiceResult;
        this.setAsideResult = setAsideResult;
    }
}
