package regenwormenshared;

import java.util.ArrayList;
import java.util.Random;

public class Worp {

    public Worp() {
        
    }

    public ArrayList<Dobbelsteen> GenereerWorp(int aantal) {
        ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<>();
        for (int i = 0; i < aantal; i++){
            dobbelstenen.add(GenereerDobbelsteen());
        }
        return dobbelstenen;
    }

    public Dobbelsteen GenereerDobbelsteen(){
        Random rnd = new Random();
        int waarde = rnd.nextInt(6) + 1;
        if (waarde == 6){
            return new Dobbelsteen(5, true);
        }
        else{
            return new Dobbelsteen(waarde, false);
        }
    }
}
