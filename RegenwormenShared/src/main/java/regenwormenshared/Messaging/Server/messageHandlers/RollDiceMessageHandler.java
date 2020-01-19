package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.server.IGameServer;
import regenwormenshared.messaging.messages.client.RollDiceMessage;

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
