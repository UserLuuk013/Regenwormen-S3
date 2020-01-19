package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.SetAsideResultMessage;

public class SetAsideResultMessageHandler extends MessageHandlerBase<SetAsideResultMessage> {
    private IGameClient client;

    public SetAsideResultMessageHandler(IGameClient client){
        this.client = client;
    }

    @Override
    public void handleMessageInternal(SetAsideResultMessage message, String sessionId) {
        this.client.processSetAsideResult(sessionId, message.getSetAsideResult());
    }
}
