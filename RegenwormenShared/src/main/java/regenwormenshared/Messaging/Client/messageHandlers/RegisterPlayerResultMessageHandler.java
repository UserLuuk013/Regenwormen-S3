package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Messaging.Messages.Server.RegisterPlayerResultMessage;

public class RegisterPlayerResultMessageHandler extends MessageHandlerBase<RegisterPlayerResultMessage> {
    private IGameClient client;

    public RegisterPlayerResultMessageHandler(IGameClient client){
        this.client = client;
    }

    @Override
    public void handleMessageInternal(RegisterPlayerResultMessage message, String sessionId) {
        this.client.processRegisterPlayerResult(sessionId, message.isResult());
    }
}
