package regenwormenshared.DTO;

public class TileDTO {
    private int value;
    private String image;
    private int amountOfRegenwormen;

    public TileDTO(){

    }

    public TileDTO(int value, String image, int amountOfRegenwormen){
        this.value = value;
        this.image = image;
        this.amountOfRegenwormen = amountOfRegenwormen;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
