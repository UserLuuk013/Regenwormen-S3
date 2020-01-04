package regenwormenclient;

import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.*;
import regenwormenshared.Messaging.Client.messageHandlers.ClientMessageHandlerFactory;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;
import websocketsclient.WebSocketsClientEndpoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    private static IGameClient gameClient;
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        start();
        rollDice();
    }

    public static void start(){
        IWebSocketsClientEndpoint socket = new WebSocketsClientEndpoint();
        IClientMessageGenerator generator = new ClientMessageGenerator(socket);

        gameClient = new GameClient(generator);
        IMessageHandlerFactory factory = new ClientMessageHandlerFactory();

        IClientMessageProcessor processor = new ClientMessageProcessor(factory);
        socket.setMessageProcessor(processor);

        socket.start();
        processor.registerGameClient(gameClient);
    }

    private static void playerRegister(){
        gameClient.registerPlayer("UserLuuk2020", "Regenwormen2020!");
    }

    private static void playerLogin(){
        gameClient.loginPlayer("UserLuuk2020", "Regenwormen2020!");
    }

    private static void rollDice(){
        gameClient.rollDice();
    }

    private static void setAside(){
        // Instantiate RollDiceResult
        List<Dice> thrownDices = new ArrayList<>();
        thrownDices.add(new Dice(1, "image.jpg", false));
        thrownDices.add(new Dice(1, "image.jpg", false));
        thrownDices.add(new Dice(2, "image.jpg", false));

        RollDiceResult rollDiceResult = new RollDiceResult(thrownDices);

        // Instantiate SetAsideResult
        List<Dice> takenDices = new ArrayList<>();
        Dice chosenDice = new Dice(1, "image.jpg", false);

        SetAsideResult setAsideResult = new SetAsideResult(takenDices, chosenDice);

        // Executing SetAside of GameClient
//        gameClient.setAside(rollDiceResult, setAsideResult);
        gameClient.setAside(chosenDice);
    }

    private static void takeTile(){
        // Instantiate SetAsideResult
        List<Dice> takenDices = new ArrayList<>();
        takenDices.add(new Dice(5, "image.jpg", false));
        takenDices.add(new Dice(5, "image.jpg", false));
        takenDices.add(new Dice(5, "image.jpg", false));
        takenDices.add(new Dice(5, "image.jpg", true));
        takenDices.add(new Dice(5, "image.jpg", false));

        Dice chosenDice = new Dice(1, "image.jpg", false);

        SetAsideResult setAsideResult = new SetAsideResult(takenDices, chosenDice);

        // Instantiate TakeTileResult
        Tile chosenTile = new Tile(21, "image.jpg", 1);

        List<Tile> chosenStackOrRow = new ArrayList<>();
        chosenStackOrRow.add(new Tile(21, "image.jpg", 1));
        chosenStackOrRow.add(new Tile(22, "image.jpg", 1));
        chosenStackOrRow.add(new Tile(23, "image.jpg", 1));
        chosenStackOrRow.add(new Tile(24, "image.jpg", 1));

        List<Tile> stack = new ArrayList<>();

        TakeTileResult takeTileResult = new TakeTileResult(chosenTile, chosenStackOrRow, stack);

        // Executing TakeTile of GameClient
//        gameClient.takeTile(setAsideResult, takeTileResult);
        gameClient.takeTile(chosenTile);
    }

    private static void returnTile(){
        // Instantiate ReturnTileResult
        List<Tile> row = new ArrayList<>();
        row.add(new Tile(21, "image.jpg", 1));
        row.add(new Tile(22, "image.jpg", 1));

        List<Tile> stack = new ArrayList<>();
        stack.add(new Tile(23, "image.jpg", 1));
        stack.add(new Tile(24, "image.jpg", 1));

        ReturnTileResult returnTileResult = new ReturnTileResult(row, stack);

        // Executing ReturnTile of GameClient
//        gameClient.returnTile(returnTileResult);
        gameClient.returnTile();
    }

    private static void getAllTiles(){
        gameClient.getAllTiles();
    }

    private static void getAllDices(){

    }
}
