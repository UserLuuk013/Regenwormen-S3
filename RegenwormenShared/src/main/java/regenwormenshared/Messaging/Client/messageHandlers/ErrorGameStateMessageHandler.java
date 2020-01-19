package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.ErrorGameStateMessage;

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
