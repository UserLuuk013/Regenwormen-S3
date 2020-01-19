package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.ReturnTileResultMessage;

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
