package regenwormenshared.Messaging.Messages;

import regenwormenshared.Models.Dice;
import regenwormenshared.Results.RollDiceResult;

import java.util.List;

public class RollDiceResultMessage {

    private RollDiceResult rollDiceResult;

    public RollDiceResult getRollDiceResult(){
        return rollDiceResult;
    }

    public RollDiceResultMessage(RollDiceResult rollDiceResult){
        this.rollDiceResult = rollDiceResult;
    }
}
