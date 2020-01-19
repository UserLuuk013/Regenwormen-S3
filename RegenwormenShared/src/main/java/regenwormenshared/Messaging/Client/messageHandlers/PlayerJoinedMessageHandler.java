package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.PlayerJoinedMessage;

public class PlayerJoinedMessageHandler extends MessageHandlerBase<PlayerJoinedMessage> {
    private IGameClient client;

    public PlayerJoinedMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(PlayerJoinedMessage message, String sessionId) {
        this.client.processPlayerJoined(sessionId, message.getPlayer());
    }
}
