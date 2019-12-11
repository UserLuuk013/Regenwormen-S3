package restserver.Repositories;

import regenwormenshared.Models.Tile;
import restserver.Interfaces.ITileContext;

import java.util.List;

public class TileRepository {

    private ITileContext context;

    public TileRepository(ITileContext context){
        this.context = context;
    }

    public List<Tile> GetAll(){
        return context.GetAll();
    }
}
