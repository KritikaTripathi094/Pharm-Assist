package Database;
import java.sql.*;

/**
 *
 * @author kritss
 */
public interface DBConnection {

    
    Connection openConnection();
    void closeConnection(Connection conn);
    ResultSet runQuery(Connection conn, String query);
    int executeUpdate (Connection conn, String query);
    
    
}