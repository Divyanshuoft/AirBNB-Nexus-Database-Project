import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    static Connection conn = null;

    public static Connection connect() {
        try {
            String url = "jdbc:mysql://localhost:3306/test";
            String username = "root";
            String password = "Canada@2021";
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }
}
