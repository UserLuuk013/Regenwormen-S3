package regenwormenshared.Messaging.Server;

import regenwormenshared.Messaging.Messages.Server.*;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Enums.GameState;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
import regenwormenshared.WebSockets.IWebSocketsEndpoint;

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
    public void notifyGetAllTilesResult(String sessionId, List<Tile> tiles) {
        GetAllTilesResultMessage message = new GetAllTilesResultMessage(tiles);
        this.serverEndpoint.sendTo(sessionId, message);
    }

    @Override
    public void notifyGetAllDicesResult(String sessionId, List<Dice> dices) {
        GetAllDicesResultMessage message = new GetAllDicesResultMessage(dices);
        this.serverEndpoint.sendTo(sessionId, message);
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
}
