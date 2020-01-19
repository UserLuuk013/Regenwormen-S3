package regenwormenshared.converters;

import regenwormenshared.dto.PlayerDTO;
import regenwormenshared.models.Player;

public class PlayerDTOModelConverter {

    public Player modelFromDTO(PlayerDTO dto){
        return new Player(
                dto.getId(),
                dto.getUsername(),
                dto.getPassword()
        );
    }

    public PlayerDTO modelToDTO(Player p){
        return new PlayerDTO(
                p.getId(),
                p.getUsername(),
                p.getPassword()
        );
    }
}
