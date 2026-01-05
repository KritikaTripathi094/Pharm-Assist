import database.mysqlconnection;
import java.sql.Connection;

public class TestDB {
    public static void main(String[] args) {
        mysqlconnection db = new mysqlconnection();
        Connection con = db.openConnection();

        if (con != null) {
            System.out.println("✅ Connected successfully: " + con);
        } else {
            System.out.println("❌ Connection is null");
        }
    }
}

