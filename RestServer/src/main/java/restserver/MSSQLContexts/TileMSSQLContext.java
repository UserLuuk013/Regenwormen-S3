package restserver.MSSQLContexts;

import regenwormenshared.Models.Tile;
import restserver.DataConnection;
import restserver.Interfaces.ITileContext;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TileMSSQLContext extends DataConnection implements ITileContext {

    public TileMSSQLContext() {

    }

    @Override
    public List<Tile> GetAll() {
        List<Tile> tiles = new ArrayList<>();
        try{
            String query = "SELECT * FROM Tile";
            ResultSet rs = ExecuteQuery(query);
            while(rs.next()){
                tiles.add(new Tile(rs.getInt("Value"), rs.getString("Image"), rs.getInt("AmountOfRegenwormen")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tiles;
    }
}
