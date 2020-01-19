package regenwormenshared.websockets;

import regenwormenshared.messagehandling.processor.IMessageProcessor;

public interface IWebSockets {

    void start();

    void stop();

    void setMessageProcessor(IMessageProcessor processor);
}
