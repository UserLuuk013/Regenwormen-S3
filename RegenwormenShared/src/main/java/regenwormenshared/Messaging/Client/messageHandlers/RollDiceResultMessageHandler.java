package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.RollDiceResultMessage;

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
