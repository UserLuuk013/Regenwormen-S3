package regenwormenshared.Messaging.Client;

import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

public interface IGameClient {
    void rollDice(int numberOfDices);
    void setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult);
    void takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult);
    void returnTile(ReturnTileResult returnTileResult);
    void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void processSetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void processTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
}
