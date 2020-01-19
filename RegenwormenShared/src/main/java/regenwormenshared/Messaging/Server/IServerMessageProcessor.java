package regenwormenshared.messaging.server;

import regenwormenshared.messageHandling.processor.IMessageProcessor;

public interface IServerMessageProcessor extends IMessageProcessor {
    void registerGame(IGameServer game);
}
