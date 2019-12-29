package regenwormenshared.Messaging.Server;

import regenwormenshared.Messaging.Messages.ReturnTileResultMessage;
import regenwormenshared.Messaging.Messages.RollDiceResultMessage;
import regenwormenshared.Messaging.Messages.SetAsideResultMessage;
import regenwormenshared.Messaging.Messages.TakeTileResultMessage;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
import regenwormenshared.WebSockets.IWebSocketsEndpoint;

public class ServerMessageGenerator implements IServerMessageGenerator {
    private IWebSocketsEndpoint serverEndpoint;

    public ServerMessageGenerator(IWebSocketsEndpoint serverEndpoint){
        this.serverEndpoint = serverEndpoint;
    }

    @Override
    public void notifyRollDiceResult(String sessionId, RollDiceResult rollDiceResult) {
        RollDiceResultMessage message = new RollDiceResultMessage(rollDiceResult);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifySetAsideResult(String sessionId, SetAsideResult setAsideResult) {
        SetAsideResultMessage message = new SetAsideResultMessage(setAsideResult);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifyTakeTileResult(String sessionId, TakeTileResult takeTileResult) {
        TakeTileResultMessage message = new TakeTileResultMessage(takeTileResult);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifyReturnTileResult(String sessionId, ReturnTileResult returnTileResult) {
        ReturnTileResultMessage message = new ReturnTileResultMessage(returnTileResult);
        this.serverEndpoint.broadcast(message);
    }
}
