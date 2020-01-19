package regenwormenshared.messaging.server.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.Client.LoginPlayerMessage;
import regenwormenshared.messaging.server.IGameServer;

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
