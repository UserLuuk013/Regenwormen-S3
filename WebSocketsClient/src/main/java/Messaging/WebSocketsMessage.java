package Messaging;

import Messaging.Interfaces.Message;
import Messaging.Interfaces.PayLoad;

public class WebSocketsMessage implements Message {
    private PayLoad payload;
    private String type;
    private String data;

    public WebSocketsMessage(PayLoad payload, String type){
        this.payload = payload;
        this.type = type;
    }

    public WebSocketsMessage(String type, String data){
        this.type = type;
        this.data = data;
    }

    @Override
    public PayLoad getPayload() {
        return this.payload;
    }

    @Override
    public String getType() {
        return this.type;
    }

    public String getData() {
        return this.data;
    }
}
