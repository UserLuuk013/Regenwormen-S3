package regenwormenclient;

import regenwormenshared.Messaging.Client.IGame;
import regenwormenshared.Models.Dice;

import java.util.List;

public class Game implements IGame {

    @Override
    public void processDiceThrowResult(String sessionId, List<Dice> dices) {
        System.out.println("DiceThrow result from Player " + sessionId + " is:");
        for(Dice dice : dices){
            System.out.println(dice.getValue());
        }
    }
}
