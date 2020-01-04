package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.EndRollDiceResultMessage;

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
