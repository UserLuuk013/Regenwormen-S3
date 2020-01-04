package regenwormenshared.Messaging.Messages.Client;

import regenwormenshared.Models.Dice;

public class SetAsideMessage {

    private Dice chosenDice;

    public Dice getChosenDice() {
        return chosenDice;
    }

    public SetAsideMessage(Dice chosenDice) {
        this.chosenDice = chosenDice;
    }
}
