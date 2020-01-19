package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.GameEndedResultMessage;

public class GameEndedResultMessageHandler extends MessageHandlerBase<GameEndedResultMessage> {
    private IGameClient client;

    public GameEndedResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(GameEndedResultMessage message, String sessionId) {
        this.client.processGameEndedResult(sessionId, message.getScorePlayer1(), message.getScorePlayer2(), message.isDraw());
    }
}
