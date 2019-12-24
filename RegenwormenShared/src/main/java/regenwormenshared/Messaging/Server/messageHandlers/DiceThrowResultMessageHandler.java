package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Client.IGame;
import regenwormenshared.Messaging.Messages.DiceThrowResultMessage;

public class DiceThrowResultMessageHandler extends MessageHandlerBase<DiceThrowResultMessage> {

    private IGame game;

    public DiceThrowResultMessageHandler(IGame game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(DiceThrowResultMessage message, String sessionId) {
        game.processDiceThrowResult(sessionId, message.getDices());
    }
}
