package regenwormenshared.Converters;

import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Tile;

public class TileDTOModelConverter {

    public Tile ModelFromDTO(TileDTO dto){
        Tile t = new Tile(
                dto.getValue(),
                dto.getImage(),
                dto.getAmountOfRegenwormen()
        );
        return t;
    }

    public TileDTO ModelToDTO(Tile t){
        TileDTO dto = new TileDTO(
                t.getValue(),
                t.getImage(),
                t.getAmountOfRegenwormen()
        );
        return dto;
    }
}
