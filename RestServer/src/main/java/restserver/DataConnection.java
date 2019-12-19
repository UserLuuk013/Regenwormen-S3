package restserver;

import java.sql.*;

public class DataConnection {

    private String connectionUrl;
    private Connection conn;

    public DataConnection() {
        connectionUrl = "jdbc:sqlserver://mssql.fhict.local;databaseName=dbi409381_regenworm;";
        try{
            conn = DriverManager.getConnection(connectionUrl, "dbi409381_regenworm", "UserLuuk013!");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
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

    public void ExecuteQueryNoResultSet(String query){
        try{
//            Statement stmt = conn.createStatement();
//            stmt.executeQuery(query);
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
