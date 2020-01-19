package regenwormenshared.messaging.server;

import regenwormenshared.messagehandling.handler.IMessageHandler;
import regenwormenshared.messagehandling.handler.IMessageHandlerFactory;
import regenwormenshared.messagehandling.processor.MessageProcessorBase;

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
