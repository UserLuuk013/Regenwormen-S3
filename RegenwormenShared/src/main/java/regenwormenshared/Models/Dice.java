package regenwormenshared.models;

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

    public boolean isRegenworm() {
        return regenworm;
    }

    @Override
    public boolean equals(Object object){
        return object instanceof Dice && this.value == ((Dice) object).getValue() && this.isRegenworm() == ((Dice) object).isRegenworm();
    }

    @Override
    public int hashCode() {
        return this.value;
    }
}
