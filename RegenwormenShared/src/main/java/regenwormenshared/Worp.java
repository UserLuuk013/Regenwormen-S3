package regenwormenshared;

import java.util.ArrayList;

public class Worp {
    private ArrayList<Dobbelsteen> dobbelstenen;
    private int waarde;

    public Worp(ArrayList<Dobbelsteen> dobbelstenen, int waarde){
        this.dobbelstenen = dobbelstenen;
        this.waarde = waarde;
    }

    public ArrayList<Dobbelsteen> getDobbelstenen() {
        return dobbelstenen;
    }

    public void setDobbelstenen(ArrayList<Dobbelsteen> dobbelstenen) {
        this.dobbelstenen = dobbelstenen;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }
}
