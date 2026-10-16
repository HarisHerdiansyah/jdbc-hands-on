package config;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DBUtil {
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/course_registration";
    private static final String jdbcUsername = "root";
    private static final String jdbcPassword = "yamabuki";

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
    }
}
