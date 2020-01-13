package restserver.ResponseHelpers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.Responses.PlayerResponse;
import restserver.Endpoints.RestTileEndpoint;

public class PlayerResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(RestTileEndpoint.class);
    private static final Gson gson = new Gson();

    static String getErrorResponseString(){
        PlayerResponse response = new PlayerResponse();
        response.setSuccess(false);
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
