package restclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import restserver.Responses.RestResponse;
import restserver.Endpoints.RestEndpoint;

public class RestClient {

    private static final Logger log = LoggerFactory.getLogger(RestEndpoint.class);

    private final String url = "http://localhost:8090/regenwormen";

    private final Gson gson = new Gson();

    public RestClient(){
        // Nothing
    }

    public List<DiceDTO> getAllDices(){
        String queryGet = "/dice/all";
        RestResponse response = executeQueryGet(queryGet);
        return response.getDices();
    }

    public List<TileDTO> getAllTiles(){
        String queryGet = "/tile/all";
        RestResponse response = executeQueryGet(queryGet);
        return response.getTiles();
    }

    public PlayerDTO playerLogin(String username, String password){
        PlayerDTO playerRequest = new PlayerDTO(username, password);
        String queryPost = "/player/login";
        RestResponse response = executeQueryPost(playerRequest, queryPost);
        return response.getPlayer();
    }

    public boolean playerRegister(String username, String password){
        PlayerDTO playerRequest = new PlayerDTO(username, password);
        String queryPost = "/player/register";
        RestResponse response = executeQueryPost(playerRequest, queryPost);
        return response.isSuccess();
    }

    private RestResponse executeQueryGet(String queryGet){
        //Build the query for the REST service
        final String query = url + queryGet;
        log.info("[Query Get] : " + query);

        // Execute the HTTP GET request
        HttpGet httpGet = new HttpGet(query);
        return executeHttpUriRequest(httpGet);
    }

    private RestResponse executeQueryPost(PlayerDTO playerRequest, String queryPost) {

        // Build the query for the REST service
        final String query = url + queryPost;
        log.info("[Query Post] : " + query);

        // Execute the HTTP POST request
        HttpPost httpPost = new HttpPost(query);
        httpPost.addHeader("content-type", "application/json");
        StringEntity params;
        try {
            params = new StringEntity(gson.toJson(playerRequest));
            httpPost.setEntity(params);
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(RestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeHttpUriRequest(httpPost);
    }

    private RestResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        // Execute the HttpUriRequest
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            log.info("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("[Entity] : " + entityString);
            RestResponse restResponse = gson.fromJson(entityString, RestResponse.class);
            return restResponse;
        } catch (IOException e) {
            log.info("IOException : " + e.toString());
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccess(false);
            return restResponse;
        } catch (JsonSyntaxException e) {
            log.info("JsonSyntaxException : " + e.toString());
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccess(false);
            return restResponse;
        }
    }
}
