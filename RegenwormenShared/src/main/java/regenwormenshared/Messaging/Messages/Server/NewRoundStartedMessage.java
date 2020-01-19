package regenwormenshared.messaging.messages.Server;

import regenwormenshared.models.Player;
import regenwormenshared.models.Tile;

import java.util.List;

public class NewRoundStartedMessage {

    private Player player1;
    private Player player2;
    private List<Tile> row;

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Tile> getRow() {
        return row;
    }

    public NewRoundStartedMessage(Player player1, Player player2, List<Tile> row) {
        this.player1 = player1;
        this.player2 = player2;
        this.row = row;
    }
}
