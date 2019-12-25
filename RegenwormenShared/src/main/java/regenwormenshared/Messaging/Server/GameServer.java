package regenwormenshared.Messaging.Server;

import regenwormenshared.Messaging.Server.IGameServer;
import regenwormenshared.Models.Round;
import regenwormenshared.Results.RollDiceResult;


public class GameServer implements IGameServer {

    private Round round;
    private IServerMessageGenerator messageGenerator;

    public GameServer(IServerMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void throwDices(String sessionId, int numberOfDices) {
        round = new Round();
        RollDiceResult rollDiceResult = round.RollDice(numberOfDices);
        messageGenerator.notifyThrownDices(sessionId, rollDiceResult.getThrownDices());
    }

    @Override
    public void processClientDisconnect(String sessionId) {

    }
}
