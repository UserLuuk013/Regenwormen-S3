package regenwormenshared.messagehandling.processor;

public  interface IMessageProcessor {
    void processMessage(String sessionId, String type, String data);

    void handleDisconnect(String sessionId);
}
