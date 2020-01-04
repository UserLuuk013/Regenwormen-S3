package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.GetAllDicesMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class GetAllDicesMessageHandler extends MessageHandlerBase<GetAllDicesMessage> {

    private IGameServer game;

    public GetAllDicesMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(GetAllDicesMessage message, String sessionId) {
        game.getAllDices(sessionId);
    }
}
