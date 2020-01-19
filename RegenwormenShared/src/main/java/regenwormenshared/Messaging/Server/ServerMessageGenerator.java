package regenwormenshared.messaging.server;

import regenwormenshared.messaging.messages.server.*;
import regenwormenshared.models.enums.GameState;
import regenwormenshared.models.enums.GameWarning;
import regenwormenshared.models.Player;
import regenwormenshared.models.Tile;
import regenwormenshared.results.ReturnTileResult;
import regenwormenshared.results.RollDiceResult;
import regenwormenshared.results.SetAsideResult;
import regenwormenshared.results.TakeTileResult;
import regenwormenshared.websockets.IWebSocketsEndpoint;

import java.util.List;

public class ServerMessageGenerator implements IServerMessageGenerator {
    private IWebSocketsEndpoint serverEndpoint;

    public ServerMessageGenerator(IWebSocketsEndpoint serverEndpoint){
        this.serverEndpoint = serverEndpoint;
    }

    @Override
    public void notifyRegisterPlayerResult(String sessionId, boolean result) {
        RegisterPlayerResultMessage message = new RegisterPlayerResultMessage(result);
        this.serverEndpoint.sendTo(sessionId, message);
    }

    @Override
    public void notifyLoginPlayerResult(String sessionId, Player player) {
        LoginPlayerResultMessage message = new LoginPlayerResultMessage(player);
        this.serverEndpoint.sendTo(sessionId, message);
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
    public void notifyEndRollDiceResult(String sessionId, boolean result) {
        EndRollDiceResultMessage message = new EndRollDiceResultMessage(result);
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

    @Override
    public void notifyGameEndedResult(String sessionId, int scorePlayer1, int scorePlayer2, boolean draw) {
        GameEndedResultMessage message = new GameEndedResultMessage(scorePlayer1, scorePlayer2, draw);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifyNewRoundStarted(String sessionId, Player player1, Player player2, List<Tile> row) {
        NewRoundStartedMessage message = new NewRoundStartedMessage(player1, player2, row);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifyPlayerJoined(String sessionId, Player player) {
        PlayerJoinedMessage message = new PlayerJoinedMessage(player);
        this.serverEndpoint.broadcast(message);
    }

    @Override
    public void notifyErrorGameState(String sessionId, GameState gameState) {
        ErrorGameStateMessage message = new ErrorGameStateMessage(gameState);
        this.serverEndpoint.sendTo(sessionId, message);
    }

    @Override
    public void notifyGameWarningMessage(String sessionId, GameWarning gameWarning) {
        GameWarningMessage message = new GameWarningMessage(gameWarning);
        this.serverEndpoint.sendTo(sessionId, message);
    }
}
