package restserver.Endpoints;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.Converters.DiceDTOModelConverter;
import regenwormenshared.Converters.PlayerDTOModelConverter;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.DiceDTO;
import regenwormenshared.DTO.PlayerDTO;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Dice;
import regenwormenshared.Models.Tile;
import regenwormenshared.Responses.RestResponse;
import restserver.MSSQLContexts.DiceMSSQLContext;
import restserver.MSSQLContexts.PlayerMSSQLContext;
import restserver.MSSQLContexts.TileMSSQLContext;
import restserver.Repositories.DiceRepository;
import restserver.Repositories.PlayerRepository;
import restserver.Repositories.TileRepository;
import restserver.ResponseHelpers.RestResponseHelper;

import java.util.ArrayList;
import java.util.List;

@Path("/regenwormen")
public class RestEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestEndpoint.class);

    private final DiceRepository diceRepo;
    private final PlayerRepository playerRepo;
    private final TileRepository tileRepo;

    private final DiceDTOModelConverter diceConverter;
    private final TileDTOModelConverter tileConverter;
    private final PlayerDTOModelConverter playerConverter;

    private final Gson gson;

    public RestEndpoint() throws Exception {
        diceRepo = new DiceRepository(new DiceMSSQLContext());
        playerRepo = new PlayerRepository(new PlayerMSSQLContext());
        tileRepo = new TileRepository(new TileMSSQLContext());

        diceConverter = new DiceDTOModelConverter();
        tileConverter = new TileDTOModelConverter();
        playerConverter = new PlayerDTOModelConverter();

        gson = new Gson();
    }

    @GET
    @Path("/dice/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDices(){
        log.info("GET all dices called");

        List<DiceDTO> dicesDTO = new ArrayList<>();
        for (Dice d : diceRepo.GetAll()){
            dicesDTO.add(diceConverter.ModelToDTO(d));
        }

        return Response.status(200).entity(RestResponseHelper.getAllDicesResponse(dicesDTO)).build();
    }

    @GET
    @Path("/tile/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTiles(){
        log.info("GET all tiles called");

        List<TileDTO> tilesDTO = new ArrayList<>();
        for (Tile t : tileRepo.GetAll()){
            tilesDTO.add(tileConverter.ModelToDTO(t));
        }

        return Response.status(200).entity(RestResponseHelper.getAllTilesResponse(tilesDTO)).build();
    }

    @POST
    @Path("/player/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response playerLogin(PlayerDTO playerRequest){
        log.info("POST called for login Player");
        PlayerDTO playerDTO = playerConverter.modelToDTO(playerRepo.Login(playerRequest.getUsername(), playerRequest.getPassword()));
        return Response.status(200).entity(RestResponseHelper.getSinglePlayerResponse(playerDTO)).build();
    }

    @POST
    @Path("/player/register")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response playerRegister(PlayerDTO playerRequest){
        log.info("POST called for register Player");
        RestResponse response = new RestResponse();
        response.setSuccess(playerRepo.Register(playerRequest.getUsername(), playerRequest.getPassword()));
        return Response.status(200).entity(gson.toJson(response)).build();
    }
}
