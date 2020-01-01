package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Dice;
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
    void notifyTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void notifyReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
    void notifyGetAllTilesResult(String sessionId, List<Tile> tiles);
    void notifyGetAllDicesResult(String sessionId, List<Dice> dices);
}
