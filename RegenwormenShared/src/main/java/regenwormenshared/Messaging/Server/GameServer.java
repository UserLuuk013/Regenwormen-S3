package regenwormenshared.Messaging.Server;

import regenwormenshared.Messaging.Server.IGameServer;
import regenwormenshared.Models.Round;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;


public class GameServer implements IGameServer {

    private Round round;
    private IServerMessageGenerator messageGenerator;

    public GameServer(IServerMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void rollDice(String sessionId, int numberOfDices) {
        round = new Round();
        RollDiceResult result = round.RollDice(numberOfDices);
        messageGenerator.notifyRollDiceResult(sessionId, result);
    }

    @Override
    public void setAside(String sessionId, RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        round = new Round();
        SetAsideResult result = round.SetAside(rollDiceResult, setAsideResult);
        messageGenerator.notifySetAsideResult(sessionId, result);
    }

    @Override
    public void takeTile(String sessionId, SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        round = new Round();
        TakeTileResult result = round.TakeTile(setAsideResult, takeTileResult);
        messageGenerator.notifyTakeTileResult(sessionId, result);
    }

    @Override
    public void returnTile(String sessionId, ReturnTileResult returnTileResult) {
        round = new Round();
        ReturnTileResult result = round.ReturnTile(returnTileResult);
        messageGenerator.notifyReturnTileResult(sessionId, result);
    }

    @Override
    public void processClientDisconnect(String sessionId) {

    }
}
