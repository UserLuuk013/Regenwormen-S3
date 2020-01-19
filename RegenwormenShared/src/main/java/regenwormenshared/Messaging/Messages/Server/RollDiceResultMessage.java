package regenwormenshared.messaging.messages.server;

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
