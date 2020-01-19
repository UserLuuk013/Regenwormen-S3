package regenwormenshared.messaging.messages.Server;

import regenwormenshared.models.enums.GameState;

public class ErrorGameStateMessage {

    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public ErrorGameStateMessage(GameState gameState) {
        this.gameState = gameState;
    }
}
