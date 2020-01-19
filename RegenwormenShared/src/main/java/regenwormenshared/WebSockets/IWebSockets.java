package regenwormenshared.websockets;

import regenwormenshared.messageHandling.processor.IMessageProcessor;

public interface IWebSockets {

    void start();

    void stop();

    void setMessageProcessor(IMessageProcessor processor);
}
