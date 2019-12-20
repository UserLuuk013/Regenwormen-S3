package regenwormenshared.MessageHandling.Handler;

public interface IMessageHandlerFactory {
    IMessageHandler getHandler(String simpleType, Object game);
}
