package regenwormenshared.Messaging.Client.messageHandlers;

import regenwormenshared.MessageHandling.Handler.IMessageHandler;
import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.IGameClient;

public class ClientMessageHandlerFactory implements IMessageHandlerFactory {
    @Override
    public IMessageHandler getHandler(String simpleType, Object game) {
        IGameClient client = (IGameClient)game;

        switch(simpleType){
            case "RegisterPlayerResultMessage":
                return new RegisterPlayerResultMessageHandler(client);
            case "LoginPlayerResultMessage":
                return new LoginPlayerResultMessageHandler(client);
            case "RollDiceResultMessage":
                return new RollDiceResultMessageHandler(client);
            case "SetAsideResultMessage":
                return new SetAsideResultMessageHandler(client);
            case "EndRollDiceResultMessage":
                return new EndRollDiceResultMessageHandler(client);
            case "TakeTileResultMessage":
                return new TakeTileResultMessageHandler(client);
            case "ReturnTileResultMessage":
                return new ReturnTileResultMessageHandler(client);
            case "NewRoundStartedMessage":
                return new NewRoundStartedMessageHandler(client);
            case "GameEndedResultMessage":
                return new GameEndedResultMessageHandler(client);
            case "GetAllTilesResultMessage":
                return new GetAllTilesResultMessageHandler(client);
            case "GetAllDicesResultMessage":
                return new GetAllDicesResultMessageHandler(client);
            case "PlayerJoinedMessage":
                return new PlayerJoinedMessageHandler(client);
            default:
                return null;
        }
    }
}
