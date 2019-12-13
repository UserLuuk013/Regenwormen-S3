package regenwormenshared.DTO;

public class DiceDTO {
    private int value;
    private String image;
    private boolean regenworm;

    public DiceDTO(int value, String image, boolean regenworm){
        this.value = value;
        this.image = image;
        this.regenworm = regenworm;
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

    public boolean getRegenworm() {
        return regenworm;
    }

    public void setRegenworm(boolean regenworm) {
        this.regenworm = regenworm;
    }
}
