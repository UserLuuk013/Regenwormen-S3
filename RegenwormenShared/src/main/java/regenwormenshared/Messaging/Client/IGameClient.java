package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IGameClient {
    void throwDices(int numberOfDices);
    void processThrowDices(String sessionId, List<Dice> dices);
}
