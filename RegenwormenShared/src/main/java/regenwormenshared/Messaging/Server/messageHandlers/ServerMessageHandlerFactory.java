package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Server.IGameServer;

public class ServerMessageHandlerFactory implements IMessageHandlerFactory {

    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {

        IGameServer igame = (IGameServer)game;
        switch (simpleType){
            case "ThrowDicesMessage":
                return new ThrowDicesMessageHandler(igame);
            default:
                return null;
        }
    }
}
