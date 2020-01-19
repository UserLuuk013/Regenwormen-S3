package regenwormenshared.messaging.client.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.Server.RegisterPlayerResultMessage;

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
