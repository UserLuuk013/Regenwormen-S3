package regenwormenshared.messageHandling.processor;

import regenwormenshared.messageHandling.handler.IMessageHandlerFactory;

public abstract class MessageProcessorBase {

    private IMessageHandlerFactory messageHandlerFactory;

    public IMessageHandlerFactory getMessageHandlerFactory() {
        return messageHandlerFactory;
    }

    public MessageProcessorBase(IMessageHandlerFactory messageHandlerFactory){
        this.messageHandlerFactory = messageHandlerFactory;
    }
}
