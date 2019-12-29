package regenwormenshared.Messaging.Client;

import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

public interface IClientMessageGenerator {
    void throwDices(int numberOfDices);
    void setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult);
    void takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult);
    void returnTile(ReturnTileResult returnTileResult);
}
