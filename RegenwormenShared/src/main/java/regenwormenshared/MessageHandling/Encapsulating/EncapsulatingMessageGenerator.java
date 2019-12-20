package regenwormenshared.MessageHandling.Encapsulating;

import regenwormenshared.Serialization.ISerializer;
import regenwormenshared.Serialization.SerializationProvider;

public class EncapsulatingMessageGenerator implements IEncapsulatingMessageGenerator {

    ISerializer<String> ser = SerializationProvider.getSerializer();

    public EncapsulatingMessage generateMessage(Object content)
    {
        String messageForServerJson = ser.serialize(content);
        String type = content.getClass().toString(); //toGenericString()
        return new EncapsulatingMessage(type, messageForServerJson);
    }

    public String generateMessageString(Object content)
    {
        EncapsulatingMessage msg = generateMessage(content);
        return ser.serialize(msg);
    }
}
