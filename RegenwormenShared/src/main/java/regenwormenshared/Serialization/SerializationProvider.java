package regenwormenshared.serialization;

public class SerializationProvider {

    private static ISerializer serializer;

    private SerializationProvider(){
        throw new IllegalStateException("Utility class");
    }

    public static ISerializer getSerializer(){
        if (serializer == null) serializer = new GsonSerializer();
        return serializer;
    }
}
