package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Server.IGameServer;
import regenwormenshared.Messaging.Messages.RollDiceMessage;

public class RollDiceMessageHandler extends MessageHandlerBase<RollDiceMessage> {

    private IGameServer game;

    public RollDiceMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(RollDiceMessage message, String sessionId) {
        game.rollDice(sessionId, message.getNumberOfDices());
    }
}
