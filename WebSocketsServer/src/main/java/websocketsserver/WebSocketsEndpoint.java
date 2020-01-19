package websocketsserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.messagehandling.encapsulating.EncapsulatingMessage;
import regenwormenshared.messagehandling.processor.IMessageProcessor;
import regenwormenshared.websockets.IWebSocketsEndpoint;
import regenwormenshared.websockets.WebSocketsBase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    private Logger log = LoggerFactory.getLogger(WebSocketsEndpoint.class);
    private String sessionIdMessage = "[WebSocket Session ID] : ";

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
        log.info("[WebSocket Connected] SessionID: {}", session.getId());
        sessions.add(session);
        log.info("[#sessions]: {}", sessions.size());
    }

    @OnMessage
    public void onText(String message, Session session) {
        log.info(sessionIdMessage + session.getId() + " [Received] : {}", message);
        String sessionId = session.getId();
        EncapsulatingMessage msg = getSerializer().deserialize(message, EncapsulatingMessage.class);
        getMessageProcessor().processMessage(sessionId, msg.getMessageType(), msg.getMessageData());
    }

    @OnClose
    public void onClose(CloseReason reason, Session session) {
        log.info(sessionIdMessage + session.getId() + " [Socket Closed]: {}", reason);
        getMessageProcessor().handleDisconnect(session.getId());
        sessions.remove(session);
    }

    @OnError
    public void onError(Throwable cause, Session session) {
        log.info("[ERROR]: {}", sessionIdMessage + session.getId());
        log.info("[ERROR]: {0}", cause);
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
            log.info("[IOException]: {0}", e);
        }
    }
}
