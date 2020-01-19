package regenwormenshared.messaging.server.messageHandlers;

import regenwormenshared.messageHandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.server.IGameServer;
import regenwormenshared.messaging.messages.Client.RollDiceMessage;

public class RollDiceMessageHandler extends MessageHandlerBase<RollDiceMessage> {

    private IGameServer game;

    public RollDiceMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(RollDiceMessage message, String sessionId) {
        game.rollDice(sessionId);
    }
}
