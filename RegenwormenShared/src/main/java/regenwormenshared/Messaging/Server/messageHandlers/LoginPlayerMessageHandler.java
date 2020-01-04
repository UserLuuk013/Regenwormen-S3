package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.LoginPlayerMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class LoginPlayerMessageHandler extends MessageHandlerBase<LoginPlayerMessage> {

    private IGameServer game;

    public LoginPlayerMessageHandler(IGameServer game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(LoginPlayerMessage message, String sessionId) {
        game.loginPlayer(sessionId, message.getUsername(), message.getPassword());
    }
}
