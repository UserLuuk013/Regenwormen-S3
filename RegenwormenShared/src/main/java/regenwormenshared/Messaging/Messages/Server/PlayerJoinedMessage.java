package regenwormenshared.messaging.messages.server;

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
