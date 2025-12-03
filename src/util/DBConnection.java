
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/community_app";
    private static final String USER = "root"; // replace with your MySQL username
    private static final String PASSWORD = "Spiderman143@"; // replace with your MySQL password

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // load MySQL driver
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ MySQL Database Connected.");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
