package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Server.IGameServer;
import regenwormenshared.Messaging.Messages.ThrowDicesMessage;

public class ThrowDicesMessageHandler extends MessageHandlerBase<ThrowDicesMessage> {

    private IGameServer game;

    public ThrowDicesMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(ThrowDicesMessage message, String sessionId) {
        game.throwDices(sessionId, message.getNumberOfDices());
    }
}
