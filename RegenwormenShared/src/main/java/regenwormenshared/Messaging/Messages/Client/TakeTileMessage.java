package regenwormenshared.messaging.messages.Client;

import regenwormenshared.models.Tile;

public class TakeTileMessage {

    private Tile chosenTile;

    public Tile getChosenTile() {
        return chosenTile;
    }

    public TakeTileMessage(Tile chosenTile) {
        this.chosenTile = chosenTile;
    }
}
