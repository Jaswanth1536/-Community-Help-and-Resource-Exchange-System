package ui;

import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;

import java.util.List;

public class TestCRUD {
    public static void main(String[] args) {
        try {
            UserDAO userDao = new UserDAOImpl();

            // 1️⃣ CREATE: Add a new user
            User user = new User(0, "Anita", "helpme", "Seeker");
            int newId = userDao.addUser(user);
            System.out.println("✅ User added with ID: " + newId);

            // 2️⃣ READ: Fetch user by ID
            User fetchedById = userDao.getUserById(newId);
            System.out.println("📌 Fetched by ID: " + fetchedById);

            // 3️⃣ READ: Fetch user by Name
            User fetchedByName = userDao.getUserByName("Anita");
            System.out.println("📌 Fetched by Name: " + fetchedByName);

            // 4️⃣ UPDATE: Change the user name
            fetchedById.setName("Anita Sharma");
            fetchedById.setPassword("newpass123");
            int updatedId = userDao.updateUser(fetchedById); // implement updateUser in DAO
            System.out.println("✏️ Updated user ID: " + updatedId);

            // Verify update
            User updatedUser = userDao.getUserById(updatedId);
            System.out.println("📌 After update: " + updatedUser);

            // 5️⃣ DELETE: Remove user
            boolean deleted = userDao.deleteUser(updatedId); // implement deleteUser in DAO
            System.out.println("❌ Deleted user: " + deleted);

            // Verify deletion
            User checkDeleted = userDao.getUserById(updatedId);
            System.out.println("📌 After deletion: " + checkDeleted);

            // 6️⃣ READ ALL: List all users
            List<User> allUsers = userDao.getAllUsers();
            System.out.println("📌 All users:");
            allUsers.forEach(System.out::println);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
