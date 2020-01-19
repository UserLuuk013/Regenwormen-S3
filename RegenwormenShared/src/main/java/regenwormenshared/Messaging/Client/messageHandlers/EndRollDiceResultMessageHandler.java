package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.EndRollDiceResultMessage;

public class EndRollDiceResultMessageHandler extends MessageHandlerBase<EndRollDiceResultMessage> {
    private IGameClient client;

    public EndRollDiceResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(EndRollDiceResultMessage message, String sessionId) {
        this.client.processEndRollDiceResult(sessionId, message.isResult());
    }
}
