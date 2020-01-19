package regenwormenshared.messaging.client;

import regenwormenshared.messageHandling.processor.IMessageProcessor;

public interface IClientMessageProcessor extends IMessageProcessor {
    void registerGameClient(IGameClient gameClient);
}
