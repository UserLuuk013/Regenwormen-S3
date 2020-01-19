package regenwormenshared.messaging.client;

import regenwormenshared.messaging.messages.client.*;
import regenwormenshared.models.Dice;
import regenwormenshared.models.Tile;
import regenwormenshared.websockets.IWebSocketsClientEndpoint;

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
}
