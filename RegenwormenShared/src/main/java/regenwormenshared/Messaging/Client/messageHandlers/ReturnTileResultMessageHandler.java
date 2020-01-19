package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
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
