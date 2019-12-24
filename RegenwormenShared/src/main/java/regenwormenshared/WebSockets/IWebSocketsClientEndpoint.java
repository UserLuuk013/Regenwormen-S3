package regenwormenshared.WebSockets;

public interface IWebSocketsClientEndpoint extends IWebSockets {

    void send(Object object);

    void onWebSocketsMessageReceived(String message, String sessionId);
}
