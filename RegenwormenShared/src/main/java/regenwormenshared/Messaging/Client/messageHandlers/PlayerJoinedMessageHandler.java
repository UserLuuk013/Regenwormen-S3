package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.PlayerJoinedMessage;

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
