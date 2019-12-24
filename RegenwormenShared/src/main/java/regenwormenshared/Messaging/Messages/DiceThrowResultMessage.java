package regenwormenshared.Messaging.Messages;

import regenwormenshared.Models.Dice;

import java.util.List;

public class DiceThrowResultMessage {

    private List<Dice> dices;

    public List<Dice> getDices(){
        return dices;
    }

    public DiceThrowResultMessage(List<Dice> dices){
        this.dices = dices;
    }
}
