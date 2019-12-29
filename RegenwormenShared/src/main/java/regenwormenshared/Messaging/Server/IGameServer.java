package regenwormenshared.Messaging.Server;

import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

public interface IGameServer {
    void rollDice(String sessionId, int numberOfDices);
    void setAside(String sessionId, RollDiceResult rollDiceResult, SetAsideResult setAsideResult);
    void takeTile(String sessionId, SetAsideResult setAsideResult, TakeTileResult takeTileResult);
    void returnTile(String sessionId, ReturnTileResult returnTileResult);
    void processClientDisconnect(String sessionId);
}
