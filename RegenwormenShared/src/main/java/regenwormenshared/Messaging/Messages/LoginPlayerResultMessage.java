package regenwormenshared.Messaging.Messages;

import regenwormenshared.Models.Player;

public class LoginPlayerResultMessage {

    private Player player;

    public Player getPlayer() {
        return player;
    }

    public LoginPlayerResultMessage(Player player) {
        this.player = player;
    }
}
