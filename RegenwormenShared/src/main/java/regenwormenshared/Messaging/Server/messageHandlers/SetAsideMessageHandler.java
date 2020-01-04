package regenwormenshared.Messaging.Server.messageHandlers;

import regenwormenshared.MessageHandling.Handler.MessageHandlerBase;
import regenwormenshared.Messaging.Messages.Client.SetAsideMessage;
import regenwormenshared.Messaging.Server.IGameServer;

public class SetAsideMessageHandler extends MessageHandlerBase<SetAsideMessage> {

    private IGameServer game;

    public SetAsideMessageHandler(IGameServer game){
        this.game = game;
    }

    @Override
    public void handleMessageInternal(SetAsideMessage message, String sessionId) {
        game.setAside(sessionId, message.getChosenDice());
    }
}
