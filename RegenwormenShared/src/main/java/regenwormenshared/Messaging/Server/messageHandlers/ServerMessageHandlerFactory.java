package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.IMessageHandler;
import regenwormenshared.messagehandling.handler.IMessageHandlerFactory;
import regenwormenshared.messaging.server.IGameServer;

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
            case "EndRollDiceMessage":
                return new EndRollDiceMessageHandler(igame);
            case "TakeTileMessage":
                return new TakeTileMessageHandler(igame);
            default:
                return null;
        }
    }
}
