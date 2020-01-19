package regenwormenshared.messaging.server;

import regenwormenshared.models.enums.GameState;
import regenwormenshared.models.enums.GameWarning;
import regenwormenshared.models.Player;
import regenwormenshared.models.Tile;
import regenwormenshared.results.ReturnTileResult;
import regenwormenshared.results.RollDiceResult;
import regenwormenshared.results.SetAsideResult;
import regenwormenshared.results.TakeTileResult;

import java.util.List;

public interface IServerMessageGenerator {
    void notifyRegisterPlayerResult(String sessionId, boolean result);
    void notifyLoginPlayerResult(String sessionId, Player player);
    void notifyRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void notifySetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void notifyEndRollDiceResult(String sessionId, boolean result);
    void notifyTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void notifyReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
    void notifyGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw);
    void notifyNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row);
    void notifyPlayerJoined(String sessionId, Player player);
    void notifyErrorGameState(String sessionId, GameState gameState);
    void notifyGameWarningMessage(String sessionId, GameWarning gameWarning);
}
