package regenwormenshared.Messaging.Server;

import regenwormenshared.Converters.DiceDTOModelConverter;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Player;
import regenwormenshared.Models.Round;
import regenwormenshared.Models.Tile;
import regenwormenshared.Results.ReturnTileResult;
import regenwormenshared.Results.RollDiceResult;
import regenwormenshared.Results.SetAsideResult;
import regenwormenshared.Results.TakeTileResult;
import restclient.RestClient;

import java.util.ArrayList;
import java.util.List;

public class GameServer implements IGameServer {

    private Round round;
    private RestClient restClient;
    private PlayerDTOModelConverter playerConverter;
    private TileDTOModelConverter tileConverter;
    private DiceDTOModelConverter diceConverter;
    private IServerMessageGenerator messageGenerator;

    public GameServer(IServerMessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
    }

    @Override
    public void registerPlayer(String sessionId, String username, String password) {
        restClient = new RestClient();

        boolean result = restClient.playerRegister(username, password);
        messageGenerator.notifyRegisterPlayerResult(sessionId, result);
    }

    @Override
    public void loginPlayer(String sessionId, String username, String password) {
        restClient = new RestClient();
        playerConverter = new PlayerDTOModelConverter();

        PlayerDTO playerDTO = restClient.playerLogin(username, password);
        Player player = playerConverter.ModelFromDTO(playerDTO);
        messageGenerator.notifyLoginPlayerResult(sessionId, player);
    }

    @Override
    public void rollDice(String sessionId, int numberOfDices) {
        round = new Round();
        RollDiceResult result = round.RollDice(numberOfDices);
        messageGenerator.notifyRollDiceResult(sessionId, result);
    }

    @Override
    public void setAside(String sessionId, RollDiceResult rollDiceResult, SetAsideResult setAsideResult) {
        round = new Round();
        SetAsideResult result = round.SetAside(rollDiceResult, setAsideResult);
        messageGenerator.notifySetAsideResult(sessionId, result);
    }

    @Override
    public void takeTile(String sessionId, SetAsideResult setAsideResult, TakeTileResult takeTileResult) {
        round = new Round();
        TakeTileResult result = round.TakeTile(setAsideResult, takeTileResult);
        messageGenerator.notifyTakeTileResult(sessionId, result);
    }

    @Override
    public void returnTile(String sessionId, ReturnTileResult returnTileResult) {
        round = new Round();
        ReturnTileResult result = round.ReturnTile(returnTileResult);
        messageGenerator.notifyReturnTileResult(sessionId, result);
    }

    @Override
    public void getAllTiles(String sessionId) {
        restClient = new RestClient();
        tileConverter = new TileDTOModelConverter();

        List<Tile> tiles = new ArrayList<>();

        List<TileDTO> tileDTOs = restClient.getAllTiles();
        for (TileDTO dto : tileDTOs){
            tiles.add(tileConverter.ModelFromDTO(dto));
        }
        messageGenerator.notifyGetAllTilesResult(sessionId, tiles);
    }

    @Override
    public void getAllDices(String sessionId) {
        restClient = new RestClient();
        diceConverter = new DiceDTOModelConverter();

        List<Dice> dices = new ArrayList<>();

        List<DiceDTO> diceDTOs = restClient.getAllDices();
        for (DiceDTO dto : diceDTOs){
            dices.add(diceConverter.ModelFromDTO(dto));
        }
        messageGenerator.notifyGetAllDicesResult(sessionId, dices);
    }

    @Override
    public void processClientDisconnect(String sessionId) {

    }
}
