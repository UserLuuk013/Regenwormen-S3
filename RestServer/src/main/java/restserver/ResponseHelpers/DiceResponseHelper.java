package restserver.ResponseHelpers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.DiceDTO;
import restserver.Responses.DiceResponse;
import restserver.Endpoints.RestDiceEndpoint;

import java.util.List;

public class DiceResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(RestDiceEndpoint.class);
    private static final Gson gson = new Gson();

    static String getErrorResponseString(){
        DiceResponse response = new DiceResponse();
        response.setSuccess(false);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }

    public static String getAllDicesResponse(List<DiceDTO> allDices){
        DiceResponse response = new DiceResponse();
        response.setSuccess(true);
        response.setDices(allDices);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }
}
