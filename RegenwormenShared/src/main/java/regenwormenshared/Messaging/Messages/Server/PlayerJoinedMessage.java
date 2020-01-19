package regenwormenshared.messaging.messages.Server;

import regenwormenshared.models.Player;

public class PlayerJoinedMessage {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public PlayerJoinedMessage(Player player) {
        this.player = player;
    }
}
