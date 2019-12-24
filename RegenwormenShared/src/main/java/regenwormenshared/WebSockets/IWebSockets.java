package regenwormenshared.WebSockets;

import regenwormenshared.MessageHandling.Processor.IMessageProcessor;

public interface IWebSockets {

    void start();

    void stop();

    void setMessageProcessor(IMessageProcessor processor);
}
