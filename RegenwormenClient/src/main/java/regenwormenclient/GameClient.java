package regenwormenclient;

import regenwormenshared.Messaging.Client.IClientMessageGenerator;
import regenwormenshared.Messaging.Client.IGameClient;
import regenwormenshared.Models.Dice;

import java.util.List;

public class GameClient implements IGameClient {

    IClientMessageGenerator messageGenerator;

    public GameClient(IClientMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void sendDiceThrowResult(List<Dice> dices) {
        messageGenerator.sendDiceThrowResult(dices);
    }
}
