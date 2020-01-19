package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.server.ErrorGameStateMessage;

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
