package regenwormenshared.messagehandling.handler;

public interface IMessageHandler {
    void handleMessage(String message, String sessionId);
}
