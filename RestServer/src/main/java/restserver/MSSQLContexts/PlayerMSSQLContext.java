package restserver.MSSQLContexts;

import regenwormenshared.Models.Player;
import restserver.DataConnection;
import restserver.Interfaces.IPlayerContext;

import java.sql.ResultSet;

public class PlayerMSSQLContext extends DataConnection implements IPlayerContext {
    public PlayerMSSQLContext() {

    }

    @Override
    public Player Login(String username, String password) {
        Player player = null;
        try{
            String query = "SELECT * FROM Player WHERE Username = '" + username + "' AND Password = '" + password + "'";
            ResultSet rs = ExecuteQuery(query);
            while(rs.next()){
                player = new Player(rs.getString("Username"), rs.getString("Password"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return player;
    }

    @Override
    public boolean Register(String username, String password) {
        try{
            String query = "INSERT INTO Player (Username, Password) VALUES ('" + username + "', '" + password + "')";
            ExecuteQuery(query);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
