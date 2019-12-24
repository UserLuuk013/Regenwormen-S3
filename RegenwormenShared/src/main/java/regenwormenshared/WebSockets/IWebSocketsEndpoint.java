package regenwormenshared.WebSockets;

public interface IWebSocketsEndpoint extends IWebSockets {

    void sendTo(String sessionId, Object object);

    void broadcast(Object object);

    void sendToOthers(String sessionId, Object object);
}
