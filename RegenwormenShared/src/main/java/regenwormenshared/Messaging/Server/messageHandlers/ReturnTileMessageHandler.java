package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.ReturnTileMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class ReturnTileMessageHandler extends MessageHandlerBase<ReturnTileMessage> {

    private IGameServer game;

    public ReturnTileMessageHandler(IGameServer game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(ReturnTileMessage message, String sessionId) {
        game.returnTile(sessionId, message.getReturnTileResult());
    }
}
