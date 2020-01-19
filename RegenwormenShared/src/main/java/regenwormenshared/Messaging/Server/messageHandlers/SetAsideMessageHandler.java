package regenwormenshared.messaging.server.messagehandlers;

import regenwormenshared.messagehandling.handler.MessageHandlerBase;
import regenwormenshared.messaging.messages.client.SetAsideMessage;
import regenwormenshared.messaging.server.IGameServer;

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
