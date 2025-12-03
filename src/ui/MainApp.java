package ui;

import dao.UserDAO;
import dao.UserDAOImpl;
import java.util.List;
import model.User;

public class MainApp {
    public static void main(String[] args) {
        try {
            UserDAO userDao = new UserDAOImpl();

            // 1️⃣ Add a new user
            User newUser = new User(0, "Ravi", "pass123", "Helper");
            int newId = userDao.addUser(newUser);
            System.out.println("✅ Added user with ID: " + newId);

            // 2️⃣ Fetch user by ID
            User fetchedById = userDao.getUserById(newId);
            System.out.println("📌 Fetched by ID:");
            System.out.println(fetchedById);

            // 3️⃣ Fetch user by Name
            User fetchedByName = userDao.getUserByName("Ravi");
            System.out.println("📌 Fetched by Name:");
            System.out.println(fetchedByName);

            // 4️⃣ List all users
            List<User> allUsers = userDao.getAllUsers();
            System.out.println("📌 All users:");
            allUsers.forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("❌ Something went wrong:");
            e.printStackTrace();
        }
    }
}
