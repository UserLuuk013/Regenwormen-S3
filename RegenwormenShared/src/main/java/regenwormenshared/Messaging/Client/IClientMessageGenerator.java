package regenwormenshared.Messaging.Client;

import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Tile;

public interface IClientMessageGenerator {
    void registerPlayer(String username, String password);
    void loginPlayer(String username, String password);
    void rollDice();
    void setAside(Dice chosenDice);
    void endRollDice();
    void takeTile(Tile chosenTile);
    void returnTile();
    void getAllTiles();
    void getAllDices();
}