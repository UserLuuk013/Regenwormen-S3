package restserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Objects;

public class DataConnection {

    private Connection conn;
    private static final Logger log = LoggerFactory.getLogger(DataConnection.class);
    private String errorMessage = "[ERROR]: ";

    protected DataConnection() {

        try{
            String connectionUrl = "jdbc:sqlserver://mssql.fhict.local;databaseName=dbi409381_regenworm;";
            conn = DriverManager.getConnection(connectionUrl, "dbi409381_regenworm", "UserLuuk013!");
        }
        catch (SQLException e) {
            log.info(errorMessage, e);
        }
    }

    protected ResultSet executeQuery(String query) throws SQLException {
        ResultSet rs = null;
        try (Statement stmt = conn.createStatement()) {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            log.info(errorMessage, e);
        } finally {
            conn.close();
            Objects.requireNonNull(rs).close();
        }
        return rs;
    }

    protected void executeQueryNoResultSet(String query) throws SQLException {
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            log.info(errorMessage, e);
        } finally {
            conn.close();
        }
    }
}
