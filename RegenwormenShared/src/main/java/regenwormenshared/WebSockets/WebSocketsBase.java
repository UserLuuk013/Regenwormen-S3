package regenwormenshared.websockets;

import regenwormenshared.messageHandling.encapsulating.EncapsulatingMessageGenerator;
import regenwormenshared.messageHandling.encapsulating.IEncapsulatingMessageGenerator;
import regenwormenshared.serialization.ISerializer;
import regenwormenshared.serialization.SerializationProvider;

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
