package regenwormenshared.messaging.client;

import regenwormenshared.models.Dice;
import regenwormenshared.models.Tile;

public interface IClientMessageGenerator {
    void registerPlayer(String username, String password);
    void loginPlayer(String username, String password);
    void rollDice();
    void setAside(Dice chosenDice);
    void endRollDice();
    void takeTile(Tile chosenTile);
}