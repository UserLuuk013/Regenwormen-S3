package regenwormenshared.Messaging.Client;

import regenwormenshared.MessageHandling.Processor.IMessageProcessor;

public interface IClientMessageProcessor extends IMessageProcessor {
    void registerGameClient(IGameClient gameClient);
}
