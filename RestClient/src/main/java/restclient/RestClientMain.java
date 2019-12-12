package restclient;

public class RestClientMain
{
    private static DiceRestClient restClient;

    public static void main( String[] args )
    {
        //Create the RestClient
        restClient = new DiceRestClient();
    }
}
