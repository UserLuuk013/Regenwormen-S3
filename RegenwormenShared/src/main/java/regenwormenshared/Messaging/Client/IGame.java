package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IGame {
    void processDiceThrowResult(String sessionId, List<Dice> dices);
}
