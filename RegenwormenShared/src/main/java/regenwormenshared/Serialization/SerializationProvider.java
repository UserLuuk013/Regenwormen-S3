package regenwormenshared.Serialization;

public class SerializationProvider {

    private static ISerializer serializer;

    public static ISerializer getSerializer(){
        if (serializer == null) serializer = new GsonSerializer();
        return serializer;
    }
}
