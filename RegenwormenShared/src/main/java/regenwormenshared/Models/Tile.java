package regenwormenshared.Models;

import regenwormenshared.DTO.TileDTO;

public class Tile {
    private int value;
    private boolean visible;
    private String image;
    private int amountOfRegenwormen;

    public Tile(int value, String image, int amountOfRegenwormen){
        this.value = value;
        this.image = image;
        this.amountOfRegenwormen = amountOfRegenwormen;
        this.visible = true;
    }

    public TileDTO CreateDTO() { return new TileDTO(value, image, amountOfRegenwormen); }

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAmountOfRegenwormen() {
        return amountOfRegenwormen;
    }

    public void setAmountOfRegenwormen(int amountOfRegenwormen) {
        this.amountOfRegenwormen = amountOfRegenwormen;
    }
}
