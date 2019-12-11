package restserver;

import java.sql.*;

public class DataConnection {

    private String connectionUrl;
    private Connection conn;

    public DataConnection() throws Exception {
        connectionUrl = "jdbc:sqlserver://mssql.fhict.local;databaseName=dbi409381_regenworm;";
        conn = DriverManager.getConnection(connectionUrl, "dbi409381_regenworm", "UserLuuk013!");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    }

    public ResultSet ExecuteQuery(String query){
        ResultSet rs = null;
        try{
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
}
