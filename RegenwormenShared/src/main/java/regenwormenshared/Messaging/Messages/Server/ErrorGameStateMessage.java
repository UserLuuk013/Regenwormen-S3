package regenwormenshared.messaging.messages.server;

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
