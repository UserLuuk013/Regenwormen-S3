package regenwormenshared.Converters;

import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.Models.Dice;

public class DiceDTOModelConverter {

    public Dice ModelFromDTO(DiceDTO dto){
        Dice d = new Dice(
                dto.getValue(),
                dto.getImage(),
                dto.getRegenworm()
        );
        return d;
    }

    public DiceDTO ModelToDTO(Dice d){
        DiceDTO dto = new DiceDTO(
                d.getValue(),
                d.getImage(),
                d.isRegenworm()
        );
        return dto;
    }
}
