package lessonfour.hometask.util;

import lessonfour.hometask.exception.DatabaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3308/users_storage"; // Port and database name from hw3-init.sql
    private static final String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private static final Properties DB_PROPERTIES = new Properties();

    static {
        DB_PROPERTIES.put("user", "user");
        DB_PROPERTIES.put("password", "password");

        try {
            Class.forName(DRIVER_URL);
        } catch (ClassNotFoundException e) {
            throw new DatabaseException("Can't load JDBC driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
        } catch (SQLException e) {
            throw new DatabaseException("Unable get connection to DB", e);
        }
    }
}
