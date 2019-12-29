package regenwormenshared.Messaging.Client;

import regenwormenshared.Messaging.Messages.ReturnTileMessage;
import regenwormenshared.Messaging.Messages.SetAsideMessage;
import regenwormenshared.Messaging.Messages.RollDiceMessage;
import regenwormenshared.Messaging.Messages.TakeTileMessage;
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
}
