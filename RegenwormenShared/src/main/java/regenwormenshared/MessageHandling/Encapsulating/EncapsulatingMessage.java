package regenwormenshared.messageHandling.encapsulating;

public class EncapsulatingMessage {
    private String type;
    private String data;

    public EncapsulatingMessage(String type, String data)
    {
        this.type = type;
        this.data = data;
    }

    public String getMessageType()
    {
        return this.type;
    }

    public String getMessageData(){
        return this.data;
    }
}
