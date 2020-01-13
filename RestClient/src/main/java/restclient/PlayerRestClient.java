package restclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.PlayerDTO;
import restserver.Responses.PlayerResponse;
import restserver.Endpoints.RestPlayerEndpoint;


public class PlayerRestClient {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestPlayerEndpoint.class);

    private final String url = "http://localhost:8090/regenwormen";

    private final Gson gson = new Gson();

    private final int NOTDEFINED = -1;

    public PlayerRestClient(){
        // Nothing
    }

    public PlayerDTO Login(String username, String password){
        PlayerDTO playerRequest = new PlayerDTO(username, password);
        String queryPost = "/player/login";
        PlayerResponse response = executeQueryPost(playerRequest, queryPost);
//        return response.getPlayers().get(0);
        return response.getPlayer();
    }

    public boolean Register(String username, String password){
        PlayerDTO playerRequest = new PlayerDTO(username, password);
        String queryPost = "/player/register";
        PlayerResponse response = executeQueryPost(playerRequest, queryPost);
        return response.isSuccess();
    }

    private PlayerResponse executeQueryPost(PlayerDTO playerRequest, String queryPost) {

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
            Logger.getLogger(PlayerRestClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return executeHttpUriRequest(httpPost);
    }

    private PlayerResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        // Execute the HttpUriRequest
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            log.info("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("[Entity] : " + entityString);
            PlayerResponse playerResponse = gson.fromJson(entityString, PlayerResponse.class);
            return playerResponse;
        } catch (IOException e) {
            log.info("IOException : " + e.toString());
            PlayerResponse playerResponse = new PlayerResponse();
            playerResponse.setSuccess(false);
            return playerResponse;
        } catch (JsonSyntaxException e) {
            log.info("JsonSyntaxException : " + e.toString());
            PlayerResponse playerResponse = new PlayerResponse();
            playerResponse.setSuccess(false);
            return playerResponse;
        }
    }

}
