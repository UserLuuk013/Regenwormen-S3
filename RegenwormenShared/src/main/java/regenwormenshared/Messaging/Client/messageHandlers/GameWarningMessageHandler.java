package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.GameWarningMessage;

public class GameWarningMessageHandler extends MessageHandlerBase<GameWarningMessage> {
    private IGameClient client;

    public GameWarningMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(GameWarningMessage message, String sessionId) {
        this.client.processGameWarningMessage(sessionId, message.getGameWarning());
    }
}
