package regenwormenshared.Messaging.Messages;

import regenwormenshared.Models.Dice;

import java.util.List;

public class GetAllDicesResultMessage {

    private List<Dice> dices;

    public List<Dice> getDices() {
        return dices;
    }

    public GetAllDicesResultMessage(List<Dice> dices) {
        this.dices = dices;
    }
}
