package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.GameEndedResultMessage;

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
