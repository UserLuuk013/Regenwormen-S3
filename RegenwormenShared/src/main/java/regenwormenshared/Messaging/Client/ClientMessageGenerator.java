package regenwormenshared.Messaging.Client;

import regenwormenshared.Messaging.Messages.DiceThrowResultMessage;
import regenwormenshared.Models.Dice;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;

import java.util.List;

public class ClientMessageGenerator implements IClientMessageGenerator {

    private IWebSocketsClientEndpoint clientEndpoint;

    public ClientMessageGenerator(IWebSocketsClientEndpoint clientEndpoint){
        this.clientEndpoint = clientEndpoint;
    }

    @Override
    public void sendDiceThrowResult(List<Dice> dices) {
        clientEndpoint.send(new DiceThrowResultMessage(dices));
    }
}
