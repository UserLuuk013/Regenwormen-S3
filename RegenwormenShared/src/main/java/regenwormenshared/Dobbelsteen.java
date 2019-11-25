package regenwormenshared;

import java.util.Random;

public class Dobbelsteen {
    private boolean afgelegd;
    private Random waarde;
    private String image;

    public Dobbelsteen(boolean afgelegd, Random waarde, String image){
        this.afgelegd = afgelegd;
        this.waarde = waarde;
        this.image = image;
    }

    public boolean isAfgelegd() {
        return afgelegd;
    }

    public void setAfgelegd(boolean afgelegd) {
        this.afgelegd = afgelegd;
    }

    public Random getWaarde() {
        return waarde;
    }

    public void setWaarde(Random waarde) {
        this.waarde = waarde;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
