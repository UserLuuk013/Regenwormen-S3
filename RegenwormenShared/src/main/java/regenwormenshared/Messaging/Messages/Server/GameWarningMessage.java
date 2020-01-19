package regenwormenshared.messaging.messages.Server;

import regenwormenshared.models.enums.GameWarning;

public class GameWarningMessage {
    private GameWarning gameWarning;

    public GameWarning getGameWarning() {
        return gameWarning;
    }

    public GameWarningMessage(GameWarning gameWarning) {
        this.gameWarning = gameWarning;
    }
}
