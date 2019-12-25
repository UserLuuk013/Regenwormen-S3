package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.DiceThrowResultMessage;

public class DiceThrowMessageHandler extends MessageHandlerBase<DiceThrowResultMessage> {
    private IGameClient client;

    public DiceThrowMessageHandler(IGameClient client){
        this.client = client;
    }

    @Override
    public void handleMessageInternal(DiceThrowResultMessage message, String sessionId) {
        this.client.processThrowDices(sessionId, message.getDices());
    }
}
