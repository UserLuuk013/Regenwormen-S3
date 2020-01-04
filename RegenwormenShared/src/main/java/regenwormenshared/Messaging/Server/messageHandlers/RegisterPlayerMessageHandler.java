package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.RegisterPlayerMessage;
import regenwormenshared.Messaging.Server.IGameServer;

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
