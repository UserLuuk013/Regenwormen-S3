package regenwormenclient;

import regenwormenshared.messagehandling.handler.IMessageHandlerFactory;
import regenwormenshared.messaging.client.*;
import regenwormenshared.messaging.client.messagehandlers.ClientMessageHandlerFactory;
import regenwormenshared.websockets.IWebSocketsClientEndpoint;
import websocketsclient.WebSocketsClientEndpoint;

public class RegenwormenApp {

    private ClientGUI clientGUI;

    public RegenwormenApp(ClientGUI clientGUI){
        this.clientGUI = clientGUI;
    }

    public void menu(){
        clientGUI.menu();
    }

    public static void main(String[] args){
        IWebSocketsClientEndpoint socket = new WebSocketsClientEndpoint();
        IClientMessageGenerator generator = new ClientMessageGenerator(socket);

        IGameClient gameClient = new GameClient(generator);
        gameClient.registerClientGUI(new ClientGUI(gameClient));
        IMessageHandlerFactory factory = new ClientMessageHandlerFactory();

        IClientMessageProcessor processor = new ClientMessageProcessor(factory);
        socket.setMessageProcessor(processor);

        socket.start();
        processor.registerGameClient(gameClient);

        RegenwormenApp test = new RegenwormenApp(new ClientGUI(gameClient));
        test.menu();
    }
}
