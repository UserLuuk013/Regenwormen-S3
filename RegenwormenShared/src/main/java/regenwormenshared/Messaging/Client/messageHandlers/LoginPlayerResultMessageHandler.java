package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.LoginPlayerResultMessage;

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
