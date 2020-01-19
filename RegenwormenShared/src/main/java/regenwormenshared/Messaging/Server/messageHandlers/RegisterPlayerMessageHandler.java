package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.client.RegisterPlayerMessage;
import regenwormenshared.messaging.server.IGameServer;

public class RegisterPlayerMessageHandler extends MessageHandlerBase<RegisterPlayerMessage> {

    private IGameServer game;

    public RegisterPlayerMessageHandler(IGameServer game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(RegisterPlayerMessage message, String sessionId) {
        game.registerPlayer(sessionId, message.getUsername(), message.getPassword());
    }
}
