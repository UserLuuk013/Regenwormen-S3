package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IClientMessageGenerator {
    void sendDiceThrowResult(List<Dice> dices);
}
