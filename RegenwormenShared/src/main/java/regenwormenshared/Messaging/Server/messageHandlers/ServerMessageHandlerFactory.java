package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Server.IGameServer;

public class ServerMessageHandlerFactory implements IMessageHandlerFactory {

    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {

        IGameServer igame = (IGameServer)game;
        switch (simpleType){
            case "RegisterPlayerMessage":
                return new RegisterPlayerMessageHandler(igame);
            case "LoginPlayerMessage":
                return new LoginPlayerMessageHandler(igame);
            case "RollDiceMessage":
                return new RollDiceMessageHandler(igame);
            case "SetAsideMessage":
                return new SetAsideMessageHandler(igame);
            case "TakeTileMessage":
                return new TakeTileMessageHandler(igame);
            case "ReturnTileMessage":
                return new ReturnTileMessageHandler(igame);
            default:
                return null;
        }
    }
}
