package restserver.Endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restserver.MSSQLContexts.TileMSSQLContext;
import restserver.Repositories.TileRepository;

@Path("/regenwormen")
public class RestTileEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestTileEndpoint.class);
    private final TileRepository repo;
    private final Gson gson;

    public RestTileEndpoint() throws Exception {
        repo = new TileRepository(new TileMSSQLContext());
        gson = new Gson();
    }

    @GET
    @Path("/tile/all")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        log.info("GET all called");
        return Response.status(200).entity(gson.toJson(repo.GetAll())).build();
    }
}
