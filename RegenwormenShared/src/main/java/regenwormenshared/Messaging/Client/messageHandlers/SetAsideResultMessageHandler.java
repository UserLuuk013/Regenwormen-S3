package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.SetAsideResultMessage;

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
