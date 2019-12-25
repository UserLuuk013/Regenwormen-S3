package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.IGameClient;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {
    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {
        IGameClient client = (IGameClient)game;

        switch(simpleType){
            case "DiceThrowResultMessage":
                return new DiceThrowMessageHandler(client);
            default:
                return null;
        }
    }
}
