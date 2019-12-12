package restserver.Endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.Models.Dice;
import restserver.MSSQLContexts.DiceMSSQLContext;
import restserver.Repositories.DiceRepository;

import java.util.List;

@Path("/regenwormen")
public class RestDiceEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestDiceEndpoint.class);
    private final DiceRepository repo;
    private final Gson gson;

    public RestDiceEndpoint() throws Exception {
        repo = new DiceRepository(new DiceMSSQLContext());
        gson = new Gson();
    }

    @GET
    @Path("/dice/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        log.info("GET all called");
        List<Dice> dices = repo.GetAll();
        return Response.status(200).entity(gson.toJson(dices)).build();
    }
}
