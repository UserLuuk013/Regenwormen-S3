package regenwormenclient;

import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.*;
import regenwormenshared.Messaging.Client.messageHandlers.ClientMessageHandlerFactory;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;
import websocketsclient.WebSocketsClientEndpoint;

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
        gameClient.throwDices(8);
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
}
