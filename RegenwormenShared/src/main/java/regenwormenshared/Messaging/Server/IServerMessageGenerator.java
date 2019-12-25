package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IServerMessageGenerator {
    void notifyThrownDices(String sessionId, List<Dice> dices);
}
