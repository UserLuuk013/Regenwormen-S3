package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.NewRoundStartedMessage;

public class NewRoundStartedMessageHandler extends MessageHandlerBase<NewRoundStartedMessage> {
    private IGameClient client;

    public NewRoundStartedMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(NewRoundStartedMessage message, String sessionId) {
        this.client.processNewRoundStarted(sessionId, message.getPlayer1(), message.getPlayer2(), message.getRow());
    }
}
