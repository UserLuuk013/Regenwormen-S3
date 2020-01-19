package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.TakeTileResultMessage;

public class TakeTileResultMessageHandler extends MessageHandlerBase<TakeTileResultMessage> {
    private IGameClient client;

    public TakeTileResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(TakeTileResultMessage message, String sessionId) {
        this.client.processTakeTileResult(sessionId, message.getTakeTileResult());
    }
}
