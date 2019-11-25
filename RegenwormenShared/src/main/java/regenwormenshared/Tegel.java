package regenwormenshared;

public class Tegel {
    private boolean beschikbaar;
    private String image;
    private int waarde;
    private int aantalRegenwormen;

    public Tegel(boolean beschikbaar, String image, int waarde, int aantalRegenwormen){
        this.beschikbaar = beschikbaar;
        this.image = image;
        this.waarde = waarde;
        this.aantalRegenwormen = aantalRegenwormen;
    }

    public boolean isBeschikbaar() {
        return beschikbaar;
    }

    public void setBeschikbaar(boolean beschikbaar) {
        this.beschikbaar = beschikbaar;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWaarde() {
        return waarde;
    }

    public void setWaarde(int waarde) {
        this.waarde = waarde;
    }

    public int getAantalRegenwormen() {
        return aantalRegenwormen;
    }

    public void setAantalRegenwormen(int aantalRegenwormen) {
        this.aantalRegenwormen = aantalRegenwormen;
    }
}
