package regenwormenshared.WebSockets;

public interface IWebSocketsClientEndpoint extends IWebSockets {

    void send(Object object);

    void onWebSocketMessageReceived(String message, String sessionId);
}
