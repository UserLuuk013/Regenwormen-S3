package restserver.ResponseHelpers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Dice;
import regenwormenshared.Responses.DiceResponse;
import regenwormenshared.Responses.PlayerResponse;
import regenwormenshared.Responses.RestResponse;
import restserver.Endpoints.RestDiceEndpoint;
import restserver.Endpoints.RestEndpoint;

import java.util.ArrayList;
import java.util.List;

public class RestResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(RestEndpoint.class);
    private static final Gson gson = new Gson();

    public static String getErrorResponseString(){
        RestResponse response = new RestResponse();
        response.setSuccess(false);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }

    public static String getAllDicesResponse(List<DiceDTO> allDices){
        RestResponse response = new RestResponse();
        response.setSuccess(true);
        response.setDices(allDices);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }

//    public static List<DiceDTO> getDiceDTOList(List<Dice> allDices){
//        List<DiceDTO> dices = new ArrayList<>();
//        for (Dice d : allDices){
//            DiceDTO dice = d.CreateDTO();
//            dices.add(dice);
//        }
//        return dices;
//    }

    public static String getAllTilesResponse(List<TileDTO> allTiles){
        RestResponse response = new RestResponse();
        response.setSuccess(true);
        response.setTiles(allTiles);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }

    public static String getSinglePlayerResponse(PlayerDTO playerDTO){
        PlayerResponse response = new PlayerResponse();
        response.setSuccess(true);
        response.setPlayer(playerDTO);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }
}
