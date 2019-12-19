package restclient;

import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Player;
import restserver.MSSQLContexts.PlayerMSSQLContext;
import restserver.Repositories.PlayerRepository;

import java.util.List;

public class RestClientMain
{
    private static DiceRestClient diceRestClient;
    private static PlayerRestClient playerRestClient;
    private static TileRestClient tileRestClient;
    private static RestClient restClient;

    public static void main( String[] args )
    {
        //Create the RestClient
        diceRestClient = new DiceRestClient();
        playerRestClient = new PlayerRestClient();
        tileRestClient = new TileRestClient();
        restClient = new RestClient();

//        //Fill List of Dices
//        List<DiceDTO> dices = diceRestClient.getAll();
//        System.out.println(dices.size());

//        //Fill Player
//        PlayerDTO player = playerRestClient.Login("Luuk", "Regenwormen123!");
//        System.out.println(player.getUsername());

        //Fill List of Tiles
//        List<TileDTO> tiles = tileRestClient.getAll();
//        System.out.println(tiles.size());

        //Fill List of Tiles by Repo
//        boolean bool = playerRestClient.Register("Luuk", "Regenwormen123!");
//        System.out.println(bool);


        // NEW REST CLIENT

//        //Fill List of Dices
//        List<DiceDTO> dices = restClient.getAllDices();
//        System.out.println(dices.size());
//
//        // Fill List of Tiles
//        List<TileDTO> tiles = restClient.getAllTiles();
//        System.out.println(tiles.size());

        // Player Login
        PlayerDTO player = restClient.playerLogin("UserLuuk013", "Regenwormen123!");
        if (player == null){
            System.out.println("Wrong username or password");
        }
        else{
            System.out.println(player.getUsername());
        }

//        // Player Register
//        boolean bool = restClient.playerRegister("UserLuuk013", "Regenwormen123!");
//        System.out.println(bool);
    }
}
