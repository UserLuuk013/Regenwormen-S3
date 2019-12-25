package websocketsserver;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import regenwormenshared.MessageHandling.Encapsulating.EncapsulatingMessage;
import regenwormenshared.MessageHandling.Processor.IMessageProcessor;
import regenwormenshared.WebSockets.IWebSocketsEndpoint;
import regenwormenshared.WebSockets.WebSocketsBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/regenwormen/")
public class WebSocketsEndpoint extends WebSocketsBase implements IWebSocketsEndpoint {

    private IMessageProcessor messageProcessor;

    @Override
    public void setMessageProcessor(IMessageProcessor processor) {
        this.messageProcessor = processor;
    }

    public IMessageProcessor getMessageProcessor(){
        return messageProcessor;
    }
    // All sessions
    private static final List<Session> sessions = new ArrayList<>();

    @OnOpen
    public void onConnect(Session session) {
        System.out.println("[WebSocket Connected] SessionID: " + session.getId());
        String message = String.format("[New client with client side session ID]: %s", session.getId());
        sessions.add(session);
        System.out.println("[#sessions]: " + sessions.size());
    }

    @OnMessage
    public void onText(String message, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Received] : " + message);
        String sessionId = session.getId();
        EncapsulatingMessage msg = getSerializer().deserialize(message, EncapsulatingMessage.class);
        getMessageProcessor().processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + " [Socket Closed]: " + reason);
        getMessageProcessor().handleDisconnect(session.getId());
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        System.out.println("[WebSocket Session ID] : " + session.getId() + "[ERROR]: ");
        cause.printStackTrace(System.err);
    }

    @Override
    public void sendTo(String sessionId, Object object) {
        String msg = getEncapsulatingMessageGenerator().generateMessageString(object);
        sendToClient(getSessionFromId(sessionId), msg);
    }

    @Override
    public void start() {
        //START AND STOP ARE HANDLED ELSEWHERE
    }

    @Override
    public void stop() {
        //START AND STOP ARE HANDLED ELSEWHERE
    }

    public Session getSessionFromId(String sessionId){
        for (Session session : sessions){
            if (session.getId().equals(sessionId)){
                return session;
            }
        }
        return null;
    }

    @Override
    public void broadcast(Object object) {
        for (Session session : sessions){
            sendTo(session.getId(), object);
        }
    }

    @Override
    public void sendToOthers(String sessionId, Object object) {
        Session session = getSessionFromId(sessionId);
        for (Session ses : sessions){
            if (!ses.getId().equals(session.getId())){
                sendTo(ses.getId(), object);
            }
        }
    }

    private void sendToClient(Session session, String message){
        try{
            session.getBasicRemote().sendText(message);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
