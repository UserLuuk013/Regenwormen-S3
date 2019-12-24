package regenwormenshared.Messaging.Client;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.MessageHandling.Processor.MessageProcessorBase;

public class ClientMessageProcessor extends MessageProcessorBase implements IClientMessageProcessor {

    private IGameClient gameClient;

    public ClientMessageProcessor(IMessageHandlerFactory messageHandlerFactory) {
        super(messageHandlerFactory);
    }

    @Override
    public void registerGameClient(IGameClient gameClient) {
        this.gameClient = gameClient;
    }

    @Override
    public void handleDisconnect(String sessionId) {
        // Do nothing
    }

    @Override
    public void processMessage(String sessionId, String type, String data) {
        String simpleType = type.split("\\.")[type.split("\\.").length - 1];

        IMessageHandler handler = getMessageHandlerFactory().getHandler(simpleType, gameClient);
        handler.handleMessage(data, sessionId);
    }
}
