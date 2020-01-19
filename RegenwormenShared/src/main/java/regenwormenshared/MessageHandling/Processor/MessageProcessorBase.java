package regenwormenshared.messagehandling.processor;

import regenwormenshared.messagehandling.handler.IMessageHandlerFactory;

public abstract class MessageProcessorBase {

    private IMessageHandlerFactory messageHandlerFactory;

    public IMessageHandlerFactory getMessageHandlerFactory() {
        return messageHandlerFactory;
    }

    public MessageProcessorBase(IMessageHandlerFactory messageHandlerFactory){
        this.messageHandlerFactory = messageHandlerFactory;
    }
}
