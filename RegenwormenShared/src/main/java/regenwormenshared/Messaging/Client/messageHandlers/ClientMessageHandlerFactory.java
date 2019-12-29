package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.IGameClient;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {
    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {
        IGameClient client = (IGameClient)game;

        switch(simpleType){
            case "RollDiceResultMessage":
                return new RollDiceResultMessageHandler(client);
            case "SetAsideResultMessage":
                return new SetAsideResultMessageHandler(client);
            case "TakeTileResultMessage":
                return new TakeTileResultMessageHandler(client);
            case "ReturnTileResultMessage":
                return new ReturnTileResultMessageHandler(client);
            default:
                return null;
        }
    }
}
