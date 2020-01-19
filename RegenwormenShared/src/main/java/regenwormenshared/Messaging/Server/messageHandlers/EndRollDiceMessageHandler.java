package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.Client.EndRollDiceMessage;
import regenwormenshared.messaging.server.IGameServer;

public class EndRollDiceMessageHandler extends MessageHandlerBase<EndRollDiceMessage> {

    private IGameServer game;

    public EndRollDiceMessageHandler(IGameServer game) {
        this.game = game;
    }

    @Override
    public void handleMessageInternal(EndRollDiceMessage message, String sessionId) {
        game.endRollDice(sessionId);
    }
}
