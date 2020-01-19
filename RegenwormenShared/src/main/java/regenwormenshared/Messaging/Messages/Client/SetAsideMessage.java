package regenwormenshared.messaging.messages.client;

import regenwormenshared.models.Dice;

public class SetAsideMessage {

    private Dice chosenDice;

    public Dice getChosenDice() {
        return chosenDice;
    }

    public SetAsideMessage(Dice chosenDice) {
        this.chosenDice = chosenDice;
    }
}
