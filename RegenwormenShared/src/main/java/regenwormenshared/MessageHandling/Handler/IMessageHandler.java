package regenwormenshared.messageHandling.handler;

public interface IMessageHandler {
    void handleMessage(String message, String sessionId);
}
