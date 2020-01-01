package regenwormenshared.Messaging.Client;

import regenwormenshared.Messaging.Messages.*;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
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
    public void throwDices(int numberOfDices) {
        clientEndpoint.send(new RollDiceMessage(numberOfDices));
    }

    @Override
    public void setAside(RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        clientEndpoint.send(new SetAsideMessage(rollDiceResult, setAsideResult));
    }

    @Override
    public void takeTile(SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        clientEndpoint.send(new TakeTileMessage(setAsideResult, takeTileResult));
    }

    @Override
    public void returnTile(ReturnTileResult returnTileResult) {
        clientEndpoint.send(new ReturnTileMessage(returnTileResult));
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
