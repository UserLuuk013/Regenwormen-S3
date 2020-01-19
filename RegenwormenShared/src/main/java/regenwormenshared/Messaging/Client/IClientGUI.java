package regenwormenshared.messaging.client;

import regenwormenshared.models.enums.GameState;
import regenwormenshared.models.enums.GameWarning;
import regenwormenshared.models.Player;
import regenwormenshared.models.Tile;
import regenwormenshared.results.ReturnTileResult;
import regenwormenshared.results.RollDiceResult;
import regenwormenshared.results.SetAsideResult;
import regenwormenshared.results.TakeTileResult;

import java.util.List;

public interface IClientGUI {
    void processRegisterPlayerResult(String sessionId, boolean result);
    void processLoginPlayerResult(String sessionId, Player player);
    void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void processSetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void processEndRollDiceResult(String sessionId, boolean result);
    void processTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
    void processNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row);
    void processGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw);
    void processPlayerJoined(String sessionId, Player player);
    void processErrorGameStateMessage(String sessionId, GameState gameState);
    void processGameWarningMessage(String sessionId, GameWarning gameWarning);
}
