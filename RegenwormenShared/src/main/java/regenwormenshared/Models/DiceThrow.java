package regenwormenshared.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceThrow {

    public List<Dice> GenerateDiceThrow(int numberOfDices) {
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++){
            dices.add(GenerateDice());
        }
        return dices;
    }

    public Dice GenerateDice(){
        Random rnd = new Random();
        int value = rnd.nextInt(6) + 1;
        if (value == 6){
            return new Dice(5, true);
        }
        else{
            return new Dice(value, false);
        }
    }
}
