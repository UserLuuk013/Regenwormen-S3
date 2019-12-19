package websocketsclient;

import com.google.gson.Gson;

import java.net.URI;
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import javax.websocket.DeploymentException;
import java.io.IOException;
import java.net.URISyntaxException;

@ClientEndpoint
public class WebSocketsClientEndpoint {
    // Singleton
    private static WebSocketsClientEndpoint instance = null;

    /**
     * The local websocket uri to connect to.
     */
    private final String uri = "ws://localhost:8095/regenwormen/";

    private Session session;

    private String message;

    private Gson gson = null;

    // Status of the webSocket client
    boolean isRunning = false;

    // Private constructor (singleton pattern)
    private WebSocketsClientEndpoint() {
        gson = new Gson();
    }



    /**
     * Get singleton instance of this class.
     * Ensure that only one instance of this class is created.
     * @return instance of client web socket
     */
    public static WebSocketsClientEndpoint getInstance() {
        if (instance == null) {
            System.out.println("[WebSocket Client create singleton instance]");
            instance = new WebSocketsClientEndpoint();
        }
        return instance;
    }

    /**
     *  Start the connection.
     */

    @OnOpen
    public void onWebSocketConnect(Session session){
        System.out.println("[WebSocket Client open session] " + session.getRequestURI());
        this.session = session;
    }

    @OnMessage
    public void onWebSocketText(String message, Session session){
        this.message = message;
        System.out.println("[WebSocket Client message received] " + message);
        onWebSocketsMessageReceived(message, session.getId());
    }

    public void onWebSocketsMessageReceived(String message, String sessionId){
        
    }

    @OnError
    public void onWebSocketError(Session session, Throwable cause) {
        System.out.println("[WebSocket Client connection error] " + cause.toString());
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason){
        System.out.print("[WebSocket Client close session] " + session.getRequestURI());
        System.out.println(" for reason " + reason);
        session = null;
    }

    private void sendMessageToServer(String message){
        try{
            session.getBasicRemote().sendText(message);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    public void send(Object object){
//        String msg = messageGenerator.messageToString(object);
//        sendMessageToServer(msg);
    }

    /**
     * Start a WebSocket client.
     */
    public void startClient() {
        System.out.println("[WebSocket Client start]");
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(uri));

        } catch (IOException | URISyntaxException | DeploymentException ex) {
            // do something useful eventually
            ex.printStackTrace();
        }
    }

    /**
     * Stop the client when it is running.
     */
    public void stopClient(){
        System.out.println("[WebSocket Client stop]");
        try {
            session.close();

        } catch (IOException ex){
            // do something useful eventually
            ex.printStackTrace();
        }
    }
}
