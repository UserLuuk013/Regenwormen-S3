package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;

import java.util.List;

public interface IGameClient {
    void registerClientGUI(IClientGUI clientGUI);
    void registerPlayer(String username, String password);
    void loginPlayer(String username, String password);
    void rollDice();
    void setAside(Dice chosenDice);
    void endRollDice();
    void takeTile(Tile chosenTile);
    void returnTile();
    void getAllTiles();
    void getAllDices();
    void processRegisterPlayerResult(String sessionId, boolean result);
    void processLoginPlayerResult(String sessionId, Player player);
    void processRollDiceResult(String sessionId, RollDiceResult rollDiceResult);
    void processSetAsideResult(String sessionId, SetAsideResult setAsideResult);
    void processEndRollDiceResult(String sessionId, boolean result);
    void processTakeTileResult(String sessionId, TakeTileResult takeTileResult);
    void processReturnTileResult(String sessionId, ReturnTileResult returnTileResult);
    void processNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row);
    void processGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw);
    void processGetAllTilesResult(String sessionId, List<Tile> tiles);
    void processGetAllDicesResult(String sessionId, List<Dice> dices);
    void processPlayerJoined(String sessionId, Player player);
    void processErrorGameStateMessage(String sessionId, GameState gameState);
}
