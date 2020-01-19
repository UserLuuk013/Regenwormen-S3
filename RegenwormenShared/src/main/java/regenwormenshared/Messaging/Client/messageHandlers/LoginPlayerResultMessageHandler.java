package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.LoginPlayerResultMessage;

public class LoginPlayerResultMessageHandler extends MessageHandlerBase<LoginPlayerResultMessage> {
    private IGameClient client;

    public LoginPlayerResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(LoginPlayerResultMessage message, String sessionId) {
        this.client.processLoginPlayerResult(sessionId, message.getPlayer());
    }
}
