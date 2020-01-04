package regenwormenshared.Messaging.Messages.Client;

import regenwormenshared.Models.Tile;

public class TakeTileMessage {

    private Tile chosenTile;

    public Tile getChosenTile() {
        return chosenTile;
    }

    public TakeTileMessage(Tile chosenTile) {
        this.chosenTile = chosenTile;
    }
}
