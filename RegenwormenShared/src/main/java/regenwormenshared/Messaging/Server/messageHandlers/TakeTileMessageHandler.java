package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.Client.TakeTileMessage;
import regenwormenshared.messaging.server.IGameServer;

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
