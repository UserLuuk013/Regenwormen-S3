package regenwormenshared.Messaging.Client;

import regenwormenshared.Messaging.Messages.Client.*;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Tile;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;

public class ClientMessageGenerator implements IClientMessageGenerator {

    private IWebSocketsClientEndpoint clientEndpoint;

    public ClientMessageGenerator(IWebSocketsClientEndpoint clientEndpoint){
        this.clientEndpoint = clientEndpoint;
    }

    @Override
    public void registerPlayer(String username, String password) {
        clientEndpoint.send(new RegisterPlayerMessage(username, password));
    }

    @Override
    public void loginPlayer(String username, String password) {
        clientEndpoint.send(new LoginPlayerMessage(username, password));
    }

    @Override
    public void rollDice() {
        clientEndpoint.send(new RollDiceMessage());
    }

    @Override
    public void setAside(Dice chosenDice) {
        clientEndpoint.send(new SetAsideMessage(chosenDice));
    }

    @Override
    public void endRollDice() {
        clientEndpoint.send(new EndRollDiceMessage());
    }

    @Override
    public void takeTile(Tile chosenTile) {
        clientEndpoint.send(new TakeTileMessage(chosenTile));
    }

    @Override
    public void returnTile() {
        clientEndpoint.send(new ReturnTileMessage());
    }

    @Override
    public void getAllTiles() {
        clientEndpoint.send(new GetAllTilesMessage());
    }

    @Override
    public void getAllDices() {
        clientEndpoint.send(new GetAllDicesMessage());
    }
}
