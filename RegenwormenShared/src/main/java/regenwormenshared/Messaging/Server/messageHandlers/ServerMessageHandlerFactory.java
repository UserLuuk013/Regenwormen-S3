package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.IGame;

public class ServerMessageHandlerFactory implements IMessageHandlerFactory {

    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {

        IGame igame = (IGame)game;
        switch (simpleType){
            case "DiceThrowResultMessageHandler":
                return new DiceThrowResultMessageHandler(igame);
            default:
                return null;
        }
    }
}
