package restserver.MSSQLContexts;

import regenwormenshared.Models.Dice;
import restserver.DataConnection;
import restserver.Interfaces.IDiceContext;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DiceMSSQLContext extends DataConnection implements IDiceContext {

    public DiceMSSQLContext() throws Exception {

    }

    @Override
    public List<Dice> GetAll() {
        List<Dice> dices = new ArrayList<>();
        try{
            String query = "SELECT * FROM Dice";
            ResultSet rs = ExecuteQuery(query);
            while(rs.next()){
                dices.add(new Dice(rs.getInt("Value"), rs.getString("Image"), rs.getBoolean("Regenworm")));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dices;
    }
}
