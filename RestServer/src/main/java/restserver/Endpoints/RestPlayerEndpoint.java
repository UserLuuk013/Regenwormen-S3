package restserver.Endpoints;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.DTO.PlayerDTO;
import restserver.MSSQLContexts.PlayerMSSQLContext;
import restserver.Repositories.PlayerRepository;
import restserver.ResponseHelpers.PlayerResponseHelper;

@Path("/regenwormen")
public class RestPlayerEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestPlayerEndpoint.class);
    private final PlayerRepository repo;
    private final PlayerDTOModelConverter cvt;
    private final Gson gson;

    public RestPlayerEndpoint() {
        repo = new PlayerRepository(new PlayerMSSQLContext());
        cvt = new PlayerDTOModelConverter();
        gson = new Gson();
    }

    @POST
    @Path("/player/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Login(String username, String password){
        log.info("POST called for Login Player");
//        return Response.status(200).entity(gson.toJson(repo.Login(username, password))).build();
        PlayerDTO playerDTO = cvt.modelToDTO(repo.Login(username, password));
        return Response.status(200).entity(gson.toJson(PlayerResponseHelper.getSinglePlayerResponse(playerDTO))).build();
    }

    @POST
    @Path("/player/register")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Register(String username, String password){
        log.info("POST called for Register Player");
        return Response.status(200).entity(gson.toJson(repo.Register(username, password))).build();
    }
}
