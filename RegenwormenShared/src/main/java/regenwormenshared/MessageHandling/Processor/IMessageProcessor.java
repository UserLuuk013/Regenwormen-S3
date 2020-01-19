package regenwormenshared.messageHandling.processor;

public  interface IMessageProcessor {
    void processMessage(String sessionId, String type, String data);

    void handleDisconnect(String sessionId);
}
