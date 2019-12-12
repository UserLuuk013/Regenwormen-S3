package restclient;

import regenwormenshared.DTO.DiceDTO;

import java.util.List;

public class RestClientMain
{
    private static DiceRestClient restClient;

    public static void main( String[] args )
    {
        //Create the RestClient
        restClient = new DiceRestClient();

        //Fill List of Dices
        List<DiceDTO> dices = restClient.getAll();
        System.out.println(dices.size());
    }
}
