package regenwormenshared.Messaging.Messages.Server;

import regenwormenshared.Models.Enums.GameState;

public class ErrorGameStateMessage {

    private GameState gameState;

    public GameState getGameState() {
        return gameState;
    }

    public ErrorGameStateMessage(GameState gameState) {
        this.gameState = gameState;
    }
}
