package regenwormenshared.models;

public class Tile {
    private int value;
    private boolean visible;
    private int amountOfRegenwormen;

    public Tile(int value, int amountOfRegenwormen){
        this.value = value;
        this.amountOfRegenwormen = amountOfRegenwormen;
        this.visible = true;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getAmountOfRegenwormen() {
        return amountOfRegenwormen;
    }

    public void setAmountOfRegenwormen(int amountOfRegenwormen) {
        this.amountOfRegenwormen = amountOfRegenwormen;
    }

    @Override
    public boolean equals(Object object){
        return object instanceof Tile && this.value == ((Tile) object).getValue();
    }
}
