package regenwormenshared.messaging.client.messagehandlers;

import regenwormenshared.messagehandling.handler.IMessageHandler;
import regenwormenshared.messagehandling.handler.IMessageHandlerFactory;
import regenwormenshared.messaging.client.IGameClient;

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
            case "PlayerJoinedMessage":
                return new PlayerJoinedMessageHandler(client);
            case "ErrorGameStateMessage":
                return new ErrorGameStateMessageHandler(client);
            case "GameWarningMessage":
                return new GameWarningMessageHandler(client);
            default:
                return null;
        }
    }
}
