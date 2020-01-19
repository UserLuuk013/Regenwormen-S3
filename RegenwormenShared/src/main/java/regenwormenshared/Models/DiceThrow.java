package regenwormenshared.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceThrow {

    private Random rnd = new Random();
    public List<Dice> generateDiceThrow(int numberOfDices) {
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++){
            dices.add(generateDice());
        }
        return dices;
    }

    private Dice generateDice(){
        int value = rnd.nextInt(6) + 1;
        if (value == 6){
            return new Dice(5,true);
        }
        else{
            return new Dice(value,false);
        }
    }
}
