package regenwormenshared.messageHandling.handler;

public interface IMessageHandlerFactory {
    IMessageHandler getHandler(String simpleType, Object game);
}
