package regenwormenshared.MessageHandling.Handler;

public interface IMessageHandler {
    void handleMessage(String message, String sessionId);
}
