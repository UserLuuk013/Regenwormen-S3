package regenwormenshared.messagehandling.handler;

public interface IMessageHandlerFactory {
    IMessageHandler getHandler(String simpleType, Object game);
}
