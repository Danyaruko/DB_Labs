package ua.lviv.iot.model.persistent;

import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@NoArgsConstructor
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3306/patana?allowPublicKeyRetrieval=true&" +
            "createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Danyanyaa15";

    private static Connection connection = null;

    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());

        }
        return connection;
    }

}
