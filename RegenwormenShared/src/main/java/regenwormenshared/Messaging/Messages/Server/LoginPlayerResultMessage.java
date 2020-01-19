package regenwormenshared.messaging.messages.Server;

import regenwormenshared.models.Player;

public class LoginPlayerResultMessage {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public LoginPlayerResultMessage(Player player) {
        this.player = player;
    }
}
