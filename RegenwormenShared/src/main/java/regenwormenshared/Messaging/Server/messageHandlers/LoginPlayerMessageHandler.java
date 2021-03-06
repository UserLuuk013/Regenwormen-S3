package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.client.LoginPlayerMessage;
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
