package regenwormenshared.Responses;

import regenwormenshared.DTO.DiceDTO;

import java.util.Collections;
import java.util.List;

public class DiceResponse {
    private boolean success;
    private DiceDTO dice;
    private List<DiceDTO> dices;

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public DiceDTO getDice(){
        return dice;
    }

    public void setDice(DiceDTO dice){
        this.dice = dice;
    }

    public List<DiceDTO> getDices(){
        List<DiceDTO> unmodifiableDiceList = Collections.unmodifiableList(dices);
        return unmodifiableDiceList;
    }
}
