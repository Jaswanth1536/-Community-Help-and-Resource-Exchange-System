package model;

public class User {
    private int userId;
    private String name;
    private String password;
    private String type; // "Helper" or "Seeker"

    // 1. Constructor matching DAO
    public User(int userId, String name, String password, String type) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    // 2. Default constructor (optional but useful)
    public User() {}

    // 3. Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    // 4. Setters
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 5. toString() for easy printing
    @Override
    public String toString() {
        return "User{id=" + userId + ", name='" + name + "', password='" + password + "', type='" + type + "'}";
    }
}
