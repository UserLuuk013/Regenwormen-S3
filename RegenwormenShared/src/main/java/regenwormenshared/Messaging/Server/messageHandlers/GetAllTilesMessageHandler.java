package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.GetAllTilesMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class GetAllTilesMessageHandler extends MessageHandlerBase<GetAllTilesMessage> {

    private IGameServer game;

    public GetAllTilesMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(GetAllTilesMessage message, String sessionId) {
        game.getAllTiles(sessionId);
    }
}
