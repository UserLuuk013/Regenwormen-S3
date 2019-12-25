package regenwormenshared.Messaging.Client;

import regenwormenshared.Messaging.Messages.DiceThrowResultMessage;
import regenwormenshared.Messaging.Messages.ThrowDicesMessage;
import regenwormenshared.Models.Dice;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;

import java.util.List;

public class ClientMessageGenerator implements IClientMessageGenerator {

    private IWebSocketsClientEndpoint clientEndpoint;

    public ClientMessageGenerator(IWebSocketsClientEndpoint clientEndpoint){
        this.clientEndpoint = clientEndpoint;
    }

    @Override
    public void throwDices(int numberOfDices) {
        clientEndpoint.send(new ThrowDicesMessage(numberOfDices));
    }
}
