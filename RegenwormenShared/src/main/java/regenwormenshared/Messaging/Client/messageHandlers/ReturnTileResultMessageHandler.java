package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.ReturnTileResultMessage;

public class ReturnTileResultMessageHandler extends MessageHandlerBase<ReturnTileResultMessage> {
    private IGameClient client;

    public ReturnTileResultMessageHandler(IGameClient client){
        this.client = client;
    }

    @Override
    public void handleMessageInternal(ReturnTileResultMessage message, String sessionId) {
        this.client.processReturnTileResult(sessionId, message.getReturnTileResult());
    }
}
