
import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException, SQLException {
        testApp();
    }

    public static void testApp() throws SQLException {
        Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        Statement stmt = conn.createStatement();
        try {
            stmt.execute("CREATE TABLE IF NOT EXISTS members2" +
                    "( id INT NOT NULL AUTO_INCREMENT,"
                    + "full_name VARCHAR(100) NOT NULL,"
                    + "contact_number INT(100) NOT NULL,"
                    + "email VARCHAR(100) NOT NULL)");
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            stmt.close();
            conn.close();
        }

    }
}
