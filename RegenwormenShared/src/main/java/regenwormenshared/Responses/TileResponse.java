package regenwormenshared.Responses;

import regenwormenshared.DTO.TileDTO;

import java.util.Collections;
import java.util.List;

public class TileResponse {
    private boolean success;
    private TileDTO tile;
    private List<TileDTO> tiles;

    public boolean isSuccess(){
        return success;
    }

    public void setSuccess(boolean success){
        this.success = success;
    }

    public TileDTO getTile(){
        return tile;
    }

    public void setTile(TileDTO tile){
        this.tile = tile;
    }

    public List<TileDTO> getTiles(){
        List<TileDTO> unmodifiableTileList = Collections.unmodifiableList(tiles);
        return unmodifiableTileList;
    }
}
