package restserver.Endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import restserver.MSSQLContexts.PlayerMSSQLContext;
import restserver.Repositories.PlayerRepository;

@Path("/player")
public class RestPlayerEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestPlayerEndpoint.class);
    private final PlayerRepository repo;
    private final Gson gson;

    public RestPlayerEndpoint() throws Exception {
        repo = new PlayerRepository(new PlayerMSSQLContext());
        gson = new Gson();
    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(String username, String password){
        log.info("POST called for Login Player");
        return Response.status(200).entity(gson.toJson(repo.Login(username, password))).build();
    }

    @POST
    @Path("/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Register(String username, String password){
        log.info("POST called for Register Player");
        return Response.status(200).entity(gson.toJson(repo.Register(username, password))).build();
    }
}
