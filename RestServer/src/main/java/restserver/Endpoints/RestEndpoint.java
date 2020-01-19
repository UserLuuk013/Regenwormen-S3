package restserver.endpoints;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.converters.PlayerDTOModelConverter;
import regenwormenshared.dto.PlayerDTO;
import regenwormenshared.responses.RestResponse;
import restserver.mssqlcontexts.PlayerMSSQLContext;
import restserver.repositories.PlayerRepository;
import restserver.responsehelpers.RestResponseHelper;

@Path("/regenwormen")
public class RestEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestEndpoint.class);

    private final PlayerRepository playerRepo;

    private final PlayerDTOModelConverter playerConverter;

    private final Gson gson;

    public RestEndpoint() {
        playerRepo = new PlayerRepository(new PlayerMSSQLContext());
        playerConverter = new PlayerDTOModelConverter();

        gson = new Gson();
    }

    @POST
    @Path("/player/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response playerLogin(PlayerDTO playerRequest){
        log.info("POST called for login Player");
        PlayerDTO playerDTO = playerConverter.modelToDTO(playerRepo.login(playerRequest.getUsername(), playerRequest.getPassword()));
        return Response.status(200).entity(RestResponseHelper.getSinglePlayerResponse(playerDTO)).build();
    }

    @POST
    @Path("/player/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response playerRegister(PlayerDTO playerRequest){
        log.info("POST called for register Player");
        RestResponse response = new RestResponse();
        response.setSuccess(playerRepo.register(playerRequest.getUsername(), playerRequest.getPassword()));
        return Response.status(200).entity(gson.toJson(response)).build();
    }
}
