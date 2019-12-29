package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.RollDiceResultMessage;

public class RollDiceResultMessageHandler extends MessageHandlerBase<RollDiceResultMessage> {
    private IGameClient client;

    public RollDiceResultMessageHandler(IGameClient client){
        this.client = client;
    }

    @Override
    public void handleMessageInternal(RollDiceResultMessage message, String sessionId) {
        this.client.processRollDiceResult(sessionId, message.getRollDiceResult());
    }
}
