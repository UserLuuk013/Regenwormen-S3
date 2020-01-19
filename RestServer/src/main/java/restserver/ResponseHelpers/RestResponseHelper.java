package restserver.responsehelpers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.dto.PlayerDTO;
import regenwormenshared.responses.RestResponse;

public class RestResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(RestResponseHelper.class);
    private static final Gson gson = new Gson();

    private RestResponseHelper(){
        throw new IllegalStateException("Utility class");
    }

    public static String getErrorResponseString(){
        RestResponse response = new RestResponse();
        response.setSuccess(false);
        String output = gson.toJson(response);
        log.info("[Server response]: {}", output);
        return output;
    }

    public static String getSinglePlayerResponse(PlayerDTO playerDTO){
        RestResponse response = new RestResponse();
        response.setSuccess(true);
        response.setPlayer(playerDTO);
        String output = gson.toJson(response);
        log.info("[Server response]: {}", output);
        return output;
    }
}
