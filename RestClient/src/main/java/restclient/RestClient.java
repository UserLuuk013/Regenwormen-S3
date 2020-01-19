package restclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.dto.PlayerDTO;
import regenwormenshared.responses.RestResponse;

public class RestClient {

    private static final Logger log = LoggerFactory.getLogger(RestClient.class);

    private static final String URL = "http://localhost:8090/regenwormen";

    private final Gson gson = new Gson();

    public RestClient(){
        // Nothing
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

    private RestResponse executeQueryPost(PlayerDTO playerRequest, String queryPost) {

        // Build the query for the REST service
        final String query = URL + queryPost;
        log.info("[Query Post]: {}", query);

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
            log.info("[Status Line]: {}", response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("[Entity]: {}", entityString);
            return gson.fromJson(entityString, RestResponse.class);
        } catch (IOException e) {
            log.info("IOException: {0}", e);
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccess(false);
            return restResponse;
        } catch (JsonSyntaxException e) {
            log.info("JsonSyntaxException: {0}", e);
            RestResponse restResponse = new RestResponse();
            restResponse.setSuccess(false);
            return restResponse;
        }
    }
}
