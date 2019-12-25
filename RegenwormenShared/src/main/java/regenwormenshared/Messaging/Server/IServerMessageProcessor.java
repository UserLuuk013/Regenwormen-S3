package regenwormenshared.Messaging.Server;

import regenwormenshared.MessageHandling.Processor.IMessageProcessor;

public interface IServerMessageProcessor extends IMessageProcessor {
    void registerGame(IGameServer game);
}
