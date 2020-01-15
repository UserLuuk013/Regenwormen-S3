package regenwormenshared.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DiceThrow {

    public List<Dice> generateDiceThrow(int numberOfDices) {
        List<Dice> dices = new ArrayList<>();
        for (int i = 0; i < numberOfDices; i++){
            dices.add(generateDice());
        }
        return dices;
    }

    public Dice generateDice(){
        Random rnd = new Random();
        int value = rnd.nextInt(6) + 1;
        if (value == 6){
            return new Dice(5, "image.jpg",true);
        }
        else{
            return new Dice(value, "image.jpg",false);
        }
    }
}
