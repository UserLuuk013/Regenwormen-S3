package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IGameClient {
    void sendDiceThrowResult(List<Dice> dices);
}
