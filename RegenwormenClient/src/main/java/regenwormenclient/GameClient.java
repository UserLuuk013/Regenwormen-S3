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
    public void throwDices(int numberOfDices) {
        this.messageGenerator.throwDices(numberOfDices);
    }

    @Override
    public void processThrowDices(String sessionId, List<Dice> dices) {
        System.out.println("The result of the thrown dices by Player " + sessionId + " is:");
        for(Dice dice : dices){
            System.out.println(dice.getValue() + " " + dice.getRegenworm());
        }
    }


}
