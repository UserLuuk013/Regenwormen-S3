package regenwormenshared.Messaging.Server;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.MessageHandling.Processor.MessageProcessorBase;

public class ServerMessageProcessor extends MessageProcessorBase implements IServerMessageProcessor {
    private IGameServer game;

    public ServerMessageProcessor(IMessageHandlerFactory messageHandlerFactory) {
        super(messageHandlerFactory);
    }

    @Override
    public void registerGame(IGameServer game) {
        this.game = game;
    }

    public IGameServer getGame(){
        return this.game;
    }

    @Override
    public void processMessage(String sessionId, String type, String data) {
        String simpleType = type.split("\\.")[type.split("\\.").length - 1];

        IMessageHandler handler = getMessageHandlerFactory().getHandler(simpleType, game);
        handler.handleMessage(data, sessionId);
    }

    @Override
    public void handleDisconnect(String sessionId) {
        this.getGame().processClientDisconnect(sessionId);
    }
}
