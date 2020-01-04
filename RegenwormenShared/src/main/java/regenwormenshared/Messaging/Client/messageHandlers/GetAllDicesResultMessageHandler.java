package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.GetAllDicesResultMessage;

public class GetAllDicesResultMessageHandler extends MessageHandlerBase<GetAllDicesResultMessage> {
    private IGameClient client;

    public GetAllDicesResultMessageHandler(IGameClient client) {
        this.client = client;
    }

    @Override
    public void handleMessageInternal(GetAllDicesResultMessage message, String sessionId) {
        this.client.processGetAllDicesResult(sessionId, message.getDices());
    }
}
