package restserver.mssqlcontexts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import regenwormenshared.models.Player;
import restserver.DataConnection;
import restserver.interfaces.IPlayerContext;

import java.sql.ResultSet;

public class PlayerMSSQLContext extends DataConnection implements IPlayerContext {
    private static final Logger log = LoggerFactory.getLogger(PlayerMSSQLContext.class);

    @Override
    public Player login(String username, String password) {
        Player player = null;
        try{
            String query = "SELECT * FROM Player WHERE Username = '" + username + "' AND Password = '" + password + "'";
            ResultSet rs = executeQuery(query);
            while(rs.next()){
                player = new Player(rs.getString("Username"), rs.getString("Password"));
            }
        }
        catch (Exception e){
            log.info("[ERROR]", e);
        }
        return player;
    }

    @Override
    public boolean register(String username, String password) {
        try{
            String query = "INSERT INTO Player (Username, Password) VALUES ('" + username + "', '" + password + "')";
            executeQueryNoResultSet(query);
            return true;
        }
        catch (Exception e){
            log.info("[ERROR]", e);
            return false;
        }
    }
}
