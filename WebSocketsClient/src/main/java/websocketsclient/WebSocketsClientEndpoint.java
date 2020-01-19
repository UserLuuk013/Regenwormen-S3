package websocketsclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.messageHandling.encapsulating.EncapsulatingMessage;
import regenwormenshared.messageHandling.processor.IMessageProcessor;
import regenwormenshared.serialization.ISerializer;
import regenwormenshared.serialization.SerializationProvider;
import regenwormenshared.websockets.IWebSocketsClientEndpoint;
import regenwormenshared.websockets.WebSocketsBase;

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
public class WebSocketsClientEndpoint extends WebSocketsBase implements IWebSocketsClientEndpoint {
    // Singleton
    private static WebSocketsClientEndpoint instance = null;

    /**
     * The local websocket uri to connect to.
     */
    private static final String uri = "ws://localhost:8095/regenwormen/";

    private Session session;

    private static final Logger log = LoggerFactory.getLogger(WebSocketsClientEndpoint.class);

    /**
     * Get singleton instance of this class.
     * Ensure that only one instance of this class is created.
     * @return instance of client web socket
     */
    public static WebSocketsClientEndpoint getInstance() {
        if (instance == null) {
            log.info("[WebSocket Client create singleton instance]");
            instance = new WebSocketsClientEndpoint();
        }
        return instance;
    }

    @Override
    public void start() {
        log.info("[WebSocket Client start]");
        try {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            container.connectToServer(this, new URI(uri));

        } catch (IOException | URISyntaxException | DeploymentException ex) {
            // do something useful eventually
            log.info("[ERROR]", ex);
        }
    }

    @Override
    public void stop() {
        log.info("[WebSocket Client stop]");
        try {
            session.close();

        } catch (IOException ex){
            // do something useful eventually
            log.info("[ERROR]", ex);
        }
    }

    /**
     *  Start the connection.
     */

    @OnOpen
    public void onWebSocketConnect(Session session){
        log.info("[WebSocket Client open session] " + session.getRequestURI());
        this.session = session;
    }

    @OnMessage
    public void onWebSocketText(String message, Session session){
        log.info("[WebSocket Client message received] " + message);
        onWebSocketMessageReceived(message, session.getId());
    }

    public void onWebSocketMessageReceived(String message, String sessionId){
        ISerializer<String> ser = SerializationProvider.getSerializer();
        EncapsulatingMessage msg = ser.deserialize(message, EncapsulatingMessage.class);
        messageProcessor.processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    IMessageProcessor messageProcessor;

    @Override
    public void setMessageProcessor(IMessageProcessor handler) {
        this.messageProcessor = handler;
    }

    @OnError
    public void onWebSocketError(Session session, Throwable cause) {
        log.info("[WebSocket Client connection error] " + cause.toString());
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason){
        log.info("[WebSocket Client close session] " + session.getRequestURI());
        log.info(" for reason " + reason);
        session = null;
    }

    private void sendMessageToServer(String message){
        try{
            session.getBasicRemote().sendText(message);
        } catch (IOException e){
            System.out.println(e);
        }
    }

    @Override
    public void send(Object object) {
        String msg = getEncapsulatingMessageGenerator().generateMessageString(object);
        sendMessageToServer(msg);
    }
}
