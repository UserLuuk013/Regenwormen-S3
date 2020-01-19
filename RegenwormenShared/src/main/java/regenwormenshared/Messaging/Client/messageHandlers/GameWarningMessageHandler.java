package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.GameWarningMessage;

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
