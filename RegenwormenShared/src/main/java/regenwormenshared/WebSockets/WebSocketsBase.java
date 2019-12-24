package regenwormenshared.WebSockets;

import regenwormenshared.MessageHandling.Encapsulating.EncapsulatingMessageGenerator;
import regenwormenshared.MessageHandling.Encapsulating.IEncapsulatingMessageGenerator;
import regenwormenshared.Serialization.ISerializer;
import regenwormenshared.Serialization.SerializationProvider;

public abstract class WebSocketsBase {

    public IEncapsulatingMessageGenerator getEncapsulatingMessageGenerator(){
        return encapsulatingMessageGenerator;
    }

    private IEncapsulatingMessageGenerator encapsulatingMessageGenerator = new EncapsulatingMessageGenerator();

    public WebSocketsBase(){

    }

    public abstract void start();

    public abstract void stop();

    public ISerializer<String> getSerializer(){
        return SerializationProvider.getSerializer();
    }
}
