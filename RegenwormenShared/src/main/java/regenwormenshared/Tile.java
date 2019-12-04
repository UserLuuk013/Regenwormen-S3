package regenwormenshared;

public class Tile {
    private int value;
    private boolean visible;

    public Tile(int value, boolean visible){
        this.value = value;
        this.visible = visible;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean getVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
