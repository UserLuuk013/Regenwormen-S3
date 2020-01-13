package restserver.Responses;

import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;

import java.util.List;

public class RestResponse {
    private boolean success;
    private List<DiceDTO> dices;
    private List<TileDTO> tiles;
    private PlayerDTO player;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<DiceDTO> getDices() {
        return dices;
    }

    public void setDices(List<DiceDTO> dices) {
        this.dices = dices;
    }

    public List<TileDTO> getTiles() {
        return tiles;
    }

    public void setTiles(List<TileDTO> tiles) {
        this.tiles = tiles;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }
}
