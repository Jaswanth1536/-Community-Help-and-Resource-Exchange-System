

package ui;

import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDBConnection {
    public static void main(String[] args) {
        String sql = "SELECT user_id, name, type FROM Users";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("✅ Connected to DB. Users:");
            System.out.println("ID | Name | Type");
            System.out.println("---------------------");
            while (rs.next()) {
                System.out.printf("%d | %s | %s%n",
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
