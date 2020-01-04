package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.TakeTileMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class TakeTileMessageHandler extends MessageHandlerBase<TakeTileMessage> {

    private IGameServer game;

    public TakeTileMessageHandler(IGameServer game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(TakeTileMessage message, String sessionId) {
        game.takeTile(sessionId, message.getChosenTile());
    }
}
