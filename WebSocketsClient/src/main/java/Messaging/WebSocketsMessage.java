package Messaging;

import Messaging.Interfaces.Message;
import Messaging.Interfaces.PayLoad;

public class WebSocketsMessage implements Message {
    private final PayLoad payload;
    private final String type;

    public WebSocketsMessage(PayLoad payload, String type){
        this.payload = payload;
        this.type = type;
    }

    @Override
    public PayLoad getPayload() {
        return this.payload;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
