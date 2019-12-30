package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Player;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

public interface IServerMessageGenerator {
    void notifyRegisterPlayerResult(String sessionId, boolean result);
    void notifyLoginPlayerResult(String sessionId, Player player);
    void notifyRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void notifySetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void notifyTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void notifyReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
}
