package regenwormenshared.messaging.server;

import regenwormenshared.messagehandling.processor.IMessageProcessor;

public interface IServerMessageProcessor extends IMessageProcessor {
    void registerGame(IGameServer game);
}
