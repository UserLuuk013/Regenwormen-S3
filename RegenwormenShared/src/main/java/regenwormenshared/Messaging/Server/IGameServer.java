package regenwormenshared.Messaging.Server;

import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;

public interface IGameServer {
    void registerPlayer(String sessionId, String username, String password);
    void loginPlayer(String sessionId, String username, String password);
    void rollDice(String sessionId);
    void setAside(String sessionId, Dice chosenDice);
    void endRollDice(String sessionId);
    void takeTile(String sessionId, Tile chosenTile);
    void returnTile(String sessionId);
    void roundEnded(String sessionId);
    void checkGame(String sessionId);
    void startNewRound(String sessionId);
    void swapTurns();
    void gameEnded(String sessionId);
    void setupGame(String sessionId);
    void getAllTiles(String sessionId);
    void getAllDices(String sessionId);
    void processClientDisconnect(String sessionId);
    void joinGame(String sessionId, Player player);
    Player getPlayerByTurn(boolean hasTurn);
}
