package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.List;

public interface IGameClient {
    void registerPlayer(String username, String password);
    void loginPlayer(String username, String password);
    void rollDice(int numberOfDices);
    void setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult);
    void takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult);
    void returnTile(ReturnTileResult returnTileResult);
    void getAllTiles();
    void getAllDices();
    void processRegisterPlayerResult(String sessionId, boolean result);
    void processLoginPlayerResult(String sessionId, Player player);
    void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void processSetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void processTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
    void processGetAllTilesResult(String sessionId, List<Tile> tiles);
    void processGetAllDicesResult(String sessionId, List<Dice> dices);
}
