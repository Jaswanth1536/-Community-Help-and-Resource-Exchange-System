package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.DBConnection;

public class UserDAOImpl implements UserDAO {

    @Override
    public int addUser(User user) throws Exception {
        String sql = "INSERT INTO Users (name, password, type) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getType());
            int affected = ps.executeUpdate();
            if (affected == 0) throw new SQLException("Inserting user failed.");
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) return rs.getInt(1);
            }
        }
        return -1;
    }
    @Override
public int updateUser(User user) throws Exception {
    String sql = "UPDATE Users SET name = ?, password = ?, type = ? WHERE user_id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, user.getName());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getType());
        ps.setInt(4, user.getUserId());
        int affected = ps.executeUpdate();
        return affected > 0 ? user.getUserId() : -1;
    }
}

@Override
public boolean deleteUser(int userId) throws Exception {
    String sql = "DELETE FROM Users WHERE user_id = ?";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, userId);
        int affected = ps.executeUpdate();
        return affected > 0;
    }
}


    @Override
    public User getUserById(int id) throws Exception {
        String sql = "SELECT user_id, name, password, type FROM Users WHERE user_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"),
                                    rs.getString("name"),
                                    rs.getString("password"),
                                    rs.getString("type"));
                }
            }
        }
        return null;
    }

    @Override
    public User getUserByName(String name) throws Exception {
        String sql = "SELECT user_id, name, password, type FROM Users WHERE name = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("user_id"),
                                    rs.getString("name"),
                                    rs.getString("password"),
                                    rs.getString("type"));
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> list = new ArrayList<>();
        String sql = "SELECT user_id, name, password, type FROM Users";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new User(rs.getInt("user_id"),
                                  rs.getString("name"),
                                  rs.getString("password"),
                                  rs.getString("type")));
            }
        }
        return list;
    }
}
