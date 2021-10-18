package database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    private static String host = "localhost";
    private static String base = "maldives";
    private static String user = "phpmyadmin";
    private static String password = "phpmyadmin";
    private static String url = "jdbc:mysql://" + host + "/" + base + "?autoReconnect=true&useSSL=false";

    /**
     * Lazy singleton instance.
     */
    private Connection connection;

    public JdbcConnection() {
        prepareConnection();
    }

    private void prepareConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (Exception e) {
                System.err.println("Connection failed : " + e.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }


}
