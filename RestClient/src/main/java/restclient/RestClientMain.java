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
    private static PlayerRepository repo;

    public static void main( String[] args )
    {
        //Create the RestClient
        diceRestClient = new DiceRestClient();
        playerRestClient = new PlayerRestClient();
        tileRestClient = new TileRestClient();
        repo = new PlayerRepository(new PlayerMSSQLContext());

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
        boolean bool = repo.Register("Luuk", "Regenwormen123!");
        System.out.println(bool);
    }
}
