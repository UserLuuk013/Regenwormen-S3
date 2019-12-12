package restclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.Responses.DiceResponse;
import restserver.Endpoints.RestDiceEndpoint;

public class DiceRestClient {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RestDiceEndpoint.class);

    private final String url = "http://localhost:8090/regenwormen";

    private final Gson gson = new Gson();

    public DiceRestClient(){
        // Nothing
    }

    public List<DiceDTO> getAll(){
        String queryGet = "/dice/all";
        DiceResponse response = executeQueryGet(queryGet);
        return response.getDices();
    }

    private DiceResponse executeQueryGet(String queryGet){
        //Build the query for the REST service
        final String query = url + queryGet;
        log.info("[Query Get] : " + query);

        // Execute the HTTP GET request
        HttpGet httpGet = new HttpGet(query);
        return executeHttpUriRequest(httpGet);
    }

    private DiceResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        // Execute the HttpUriRequest
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            log.info("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("[Entity] : " + entityString);
            DiceResponse diceResponse = gson.fromJson(entityString, DiceResponse.class);
            return diceResponse;
        } catch (IOException e) {
            log.info("IOException : " + e.toString());
            DiceResponse diceResponse = new DiceResponse();
            diceResponse.setSuccess(false);
            return diceResponse;
        } catch (JsonSyntaxException e) {
            log.info("JsonSyntaxException : " + e.toString());
            DiceResponse diceResponse = new DiceResponse();
            diceResponse.setSuccess(false);
            return diceResponse;
        }
    }

}
