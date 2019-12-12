package restclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Responses.TileResponse;
import restserver.Endpoints.RestTileEndpoint;

import java.io.IOException;
import java.util.List;

public class TileRestClient {

    private static final org.slf4j.Logger log = (Logger) LoggerFactory.getLogger(RestTileEndpoint.class);

    private final String url = "http://localhost:8090/regenwormen";

    private final Gson gson = new Gson();

    public TileRestClient(){
        // Nothing
    }

    public List<TileDTO> getAll(){
        String queryGet = "/tile/all";
        TileResponse response = executeQueryGet(queryGet);
        return response.getTiles();
    }

    private TileResponse executeQueryGet(String queryGet) {

        // Build the query for the REST service
        final String query = url + queryGet;
        log.info("[Query Get] : " + query);

        // Execute the HTTP GET request
        HttpGet httpGet = new HttpGet(query);
        return executeHttpUriRequest(httpGet);
    }

    private TileResponse executeHttpUriRequest(HttpUriRequest httpUriRequest) {

        // Execute the HttpUriRequest
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            log.info("[Status Line] : " + response.getStatusLine());
            HttpEntity entity = response.getEntity();
            final String entityString = EntityUtils.toString(entity);
            log.info("[Entity] : " + entityString);
            TileResponse tileResponse = gson.fromJson(entityString, TileResponse.class);
            return tileResponse;
        } catch (IOException e) {
            log.info("IOException : " + e.toString());
            TileResponse tileResponse = new TileResponse();
            tileResponse.setSuccess(false);
            return tileResponse;
        } catch (JsonSyntaxException e) {
            log.info("JsonSyntaxException : " + e.toString());
            TileResponse tileResponse = new TileResponse();
            tileResponse.setSuccess(false);
            return tileResponse;
        }
    }

}
