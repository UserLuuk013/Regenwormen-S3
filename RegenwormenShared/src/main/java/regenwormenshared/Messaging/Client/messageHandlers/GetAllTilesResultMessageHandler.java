package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.GetAllTilesResultMessage;

public class GetAllTilesResultMessageHandler extends MessageHandlerBase<GetAllTilesResultMessage> {
    private IGameClient client;

    public GetAllTilesResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(GetAllTilesResultMessage message, String sessionId) {
        this.client.processGetAllTilesResult(sessionId, message.getTiles());
    }
}
