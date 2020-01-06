package regenwormenshared.Messaging.Messages.Server;

import regenwormenshared.Models.Enums.GameWarning;

public class GameWarningMessage {
    private GameWarning gameWarning;

    public GameWarning getGameWarning() {
        return gameWarning;
    }

    public GameWarningMessage(GameWarning gameWarning) {
        this.gameWarning = gameWarning;
    }
}
