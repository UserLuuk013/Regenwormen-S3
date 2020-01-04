package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.EndRollDiceMessage;
import regenwormenshared.Messaging.Server.IGameServer;

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
