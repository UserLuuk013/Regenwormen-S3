package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.NewRoundStartedMessage;

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
