package regenwormenshared.Messaging.Server;

import regenwormenshared.Messaging.Messages.DiceThrowResultMessage;
import regenwormenshared.Models.Dice;
import regenwormenshared.WebSockets.IWebSocketsEndpoint;

import java.util.List;

public class ServerMessageGenerator implements IServerMessageGenerator {
    private IWebSocketsEndpoint serverEndpoint;

    public ServerMessageGenerator(IWebSocketsEndpoint serverEndpoint){
        this.serverEndpoint = serverEndpoint;
    }

    @Override
    public void notifyThrownDices(String sessionId, List<Dice> dices) {
        DiceThrowResultMessage message = new DiceThrowResultMessage(dices);
        this.serverEndpoint.broadcast(message);
    }
}
