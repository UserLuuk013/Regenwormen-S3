package regenwormenshared.messaging.messages.Server;

import regenwormenshared.results.RollDiceResult;

public class RollDiceResultMessage {

    private RollDiceResult rollDiceResult;

    public RollDiceResult getRollDiceResult(){
        return rollDiceResult;
    }

    public RollDiceResultMessage(RollDiceResult rollDiceResult){
        this.rollDiceResult = rollDiceResult;
    }
}
