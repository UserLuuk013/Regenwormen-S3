package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.ErrorGameStateMessage;

public class ErrorGameStateMessageHandler extends MessageHandlerBase<ErrorGameStateMessage> {
    private IGameClient client;

    public ErrorGameStateMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(ErrorGameStateMessage message, String sessionId) {
        this.client.processErrorGameStateMessage(sessionId, message.getGameState());
    }
}
