package restserver.ResponseHelpers;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Responses.TileResponse;
import restserver.Endpoints.RestTileEndpoint;

import java.util.List;

public class TileResponseHelper {
    private static final Logger log = LoggerFactory.getLogger(RestTileEndpoint.class);
    private static final Gson gson = new Gson();

    static String getErrorResponseString(){
        TileResponse response = TileResponse.getInstance();
        response.setSuccess(false);
        String output = gson.toJson(response);
        log.info("[Server response] " + output);
        return output;
    }

    public static String getAllTilesResponse(List<TileDTO> allTiles){
        TileResponse response = TileResponse.getInstance();
        response.setSuccess(true);
        response.setTiles(allTiles);
        String output = gson.toJson(response);
        log.info("[Server response] " + response);
        return output;
    }
}
