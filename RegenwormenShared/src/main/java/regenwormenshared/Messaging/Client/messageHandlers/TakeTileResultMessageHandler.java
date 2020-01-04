package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.TakeTileResultMessage;

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
