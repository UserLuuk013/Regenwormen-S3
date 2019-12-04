package regenwormenshared.Models;

public class Dice {
    private int value;
    private boolean regenworm;

    public Dice(int value, boolean regenworm){
        this.value = value;
        this.regenworm = regenworm;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getRegenworm() {
        return regenworm;
    }

    public void setRegenworm(boolean regenworm) {
        this.regenworm = regenworm;
    }
}
