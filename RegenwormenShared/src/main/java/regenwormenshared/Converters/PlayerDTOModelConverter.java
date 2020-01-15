package regenwormenshared.Converters;

import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.Models.Player;

public class PlayerDTOModelConverter {

    public Player modelFromDTO(PlayerDTO dto){
        Player p = new Player(
                dto.getId(),
                dto.getUsername(),
                dto.getPassword()
        );
        return p;
    }

    public PlayerDTO modelToDTO(Player p){
        PlayerDTO dto = new PlayerDTO(
                p.getId(),
                p.getUsername(),
                p.getPassword()
        );
        return dto;
    }
}
