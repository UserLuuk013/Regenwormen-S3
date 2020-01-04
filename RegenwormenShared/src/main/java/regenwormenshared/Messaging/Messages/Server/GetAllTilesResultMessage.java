package regenwormenshared.Messaging.Messages.Server;

import regenwormenshared.Models.Tile;

import java.util.List;

public class GetAllTilesResultMessage {

    private List<Tile> tiles;

    public List<Tile> getTiles() {
        return tiles;
    }

    public GetAllTilesResultMessage(List<Tile> tiles) {
        this.tiles = tiles;
    }
}
