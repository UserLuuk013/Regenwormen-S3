package restserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataConnection {

    private Connection conn;
    private static final Logger log = LoggerFactory.getLogger(DataConnection.class);

    protected DataConnection() {
        String connectionUrl = "jdbc:sqlserver://mssql.fhict.local;databaseName=dbi409381_regenworm;";
        try{
            conn = DriverManager.getConnection(connectionUrl, "dbi409381_regenworm", "UserLuuk013!");
        }
        catch (SQLException e) {
            log.info("[ERROR]", e);
        }
    }

    protected ResultSet executeQuery(String query){
        ResultSet rs = null;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            log.info("[ERROR]", e);
        }
        return rs;
    }

    protected void executeQueryNoResultSet(String query){
        try{
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            log.info("[ERROR]", e);
        }
    }
}
