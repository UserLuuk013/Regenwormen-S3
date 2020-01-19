package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.client.IGameClient;
import regenwormenshared.messaging.messages.server.RegisterPlayerResultMessage;

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
