package regenwormenshared.MessageHandling.Processor;

import regenwormenshared.MessageHandling.Handler.IMessageHandlerFactory;

public abstract class MessageProcessorBase {

    private IMessageHandlerFactory messageHandlerFactory;

    public IMessageHandlerFactory getMessageHandlerFactory() {
        return messageHandlerFactory;
    }

    public MessageProcessorBase(IMessageHandlerFactory messageHandlerFactory){
        this.messageHandlerFactory = messageHandlerFactory;
    }
}
