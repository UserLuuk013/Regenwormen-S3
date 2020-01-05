package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

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
    void notifyGetAllTilesResult(String sessionId, List<Tile> tiles);
    void notifyGetAllDicesResult(String sessionId, List<Dice> dices);
    void notifyPlayerJoined(String sessionId, Player player);
    void notifyErrorGameState(String sessionId, GameState gameState);
}
