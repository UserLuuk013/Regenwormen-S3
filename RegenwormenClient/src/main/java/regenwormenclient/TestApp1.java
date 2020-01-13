package regenwormenclient;

import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;
import regenwormenshared.Messaging.Client.*;
import regenwormenshared.Messaging.Client.messageHandlers.ClientMessageHandlerFactory;
import regenwormenshared.WebSockets.IWebSocketsClientEndpoint;
import websocketsclient.WebSocketsClientEndpoint;

public class TestApp1 {

    private IGameClient gameClient;

    public TestApp1(IGameClient gameClient){
        this.gameClient = gameClient;
    }

    public void loginPlayer(){
        gameClient.loginPlayer("UserLuuk2020", "Regenwormen2020!");
    }

    public static void main(String[] args){
        IWebSocketsClientEndpoint socket = new WebSocketsClientEndpoint();
        IClientMessageGenerator generator = new ClientMessageGenerator(socket);

        IGameClient gameClient = new GameClient(generator);
        gameClient.registerClientGUI(new TestClientGUI(gameClient));
        IMessageHandlerFactory factory = new ClientMessageHandlerFactory();

        IClientMessageProcessor processor = new ClientMessageProcessor(factory);
        socket.setMessageProcessor(processor);

        socket.start();
        processor.registerGameClient(gameClient);

        TestApp1 test = new TestApp1(gameClient);
        test.loginPlayer();
    }
}