package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Dice;

import java.util.List;

public interface IGameServer {
    void throwDices(String sessionId, int numberOfDices);

    void processClientDisconnect(String sessionId);
}
