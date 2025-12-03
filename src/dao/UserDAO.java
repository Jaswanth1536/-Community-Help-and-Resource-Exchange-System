package dao;

import java.util.List;
import model.User;

public interface UserDAO {
    int updateUser(User user) throws Exception;
boolean deleteUser(int userId) throws Exception;

    int addUser(User user) throws Exception;
    User getUserById(int id) throws Exception;
    User getUserByName(String name) throws Exception;
    List<User> getAllUsers() throws Exception;
}
