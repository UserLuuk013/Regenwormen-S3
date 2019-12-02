package regenwormenshared;

public class Dobbelsteen {
    private int waarde;
    private boolean regenworm;

    public Dobbelsteen(int waarde, boolean regenworm){
        this.waarde = waarde;
        this.regenworm = regenworm;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public boolean getRegenworm() {
        return regenworm;
    }

    public void setRegenworm(boolean regenworm) {
        this.regenworm = regenworm;
    }
}
