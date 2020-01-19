package regenwormenshared.websockets;

import regenwormenshared.messagehandling.encapsulating.EncapsulatingMessageGenerator;
import regenwormenshared.messagehandling.encapsulating.IEncapsulatingMessageGenerator;
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
