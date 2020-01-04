package regenwormenshared.Messaging.Messages.Server;

import regenwormenshared.Models.Player;

public class PlayerJoinedMessage {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public PlayerJoinedMessage(Player player) {
        this.player = player;
    }
}
