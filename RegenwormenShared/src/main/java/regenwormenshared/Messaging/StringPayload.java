package regenwormenshared.Messaging;

import regenwormenshared.Messaging.Interfaces.PayLoad;

public class StringPayload implements PayLoad {
    private String content;

    public StringPayload(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
