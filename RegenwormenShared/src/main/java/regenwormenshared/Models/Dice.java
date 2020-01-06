package regenwormenshared.Models;

import regenwormenshared.DTO.DiceDTO;

public class Dice {
    private int value;
    private String image;
    private boolean regenworm;

    public Dice(int value, String image, boolean regenworm){
        this.value = value;
        this.image = image;
        this.regenworm = regenworm;
    }

    public DiceDTO CreateDTO() { return new DiceDTO(value, image, regenworm); };

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

    @Override
    public boolean equals(Object object){

        boolean sameSame = false;

        if (object instanceof Dice){
            if (this.value == ((Dice) object).getValue() && this.getRegenworm() == ((Dice) object).getRegenworm()){
                sameSame = true;
            }
        }
        return sameSame;
    }
}
