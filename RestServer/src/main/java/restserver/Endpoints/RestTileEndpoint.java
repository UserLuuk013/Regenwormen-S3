package restserver.Endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.Converters.TileDTOModelConverter;
import regenwormenshared.DTO.TileDTO;
import regenwormenshared.Models.Tile;
import restserver.MSSQLContexts.TileMSSQLContext;
import restserver.Repositories.TileRepository;
import restserver.ResponseHelpers.TileResponseHelper;

import java.util.ArrayList;
import java.util.List;

@Path("/regenwormen")
public class RestTileEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RestTileEndpoint.class);
    private final TileRepository repo;
    private final TileDTOModelConverter cvt;
    private final Gson gson;

    public RestTileEndpoint() {
        repo = new TileRepository(new TileMSSQLContext());
        cvt = new TileDTOModelConverter();
        gson = new Gson();
    }

    @GET
    @Path("/tile/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        log.info("GET all called");
        List<TileDTO> tilesDTO = new ArrayList<>();
        for (Tile t : repo.GetAll()){
            tilesDTO.add(cvt.ModelToDTO(t));
        }
        return Response.status(200).entity(gson.toJson(TileResponseHelper.getAllTilesResponse(tilesDTO))).build();
    }
}
