package regenwormenshared.messaging.client;

import regenwormenshared.messagehandling.processor.IMessageProcessor;

public interface IClientMessageProcessor extends IMessageProcessor {
    void registerGameClient(IGameClient gameClient);
}
