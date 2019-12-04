package regenwormenshared;

import java.util.ArrayList;
import java.util.Random;

public class DiceThrow {

    public ArrayList<Dice> GenerateDiceThrow(int numberOfDices) {
        ArrayList<Dice> dices = new ArrayList<>();
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
