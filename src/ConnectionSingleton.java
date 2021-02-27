// by Christian80gabi
// com.christian80gabi.api.socket.database

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSingleton {
    private static Connection connection;

    static String url = "jdbc:mysql://localhost:3306/api_products?serverTimezone=UTC";
    static String user = "chris";
    static String password = "ChristianSQL8.0"; // replace '???' by your database user password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}
