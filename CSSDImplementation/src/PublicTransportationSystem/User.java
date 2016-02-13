/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class User {

    private String fullName;
    private int userId;
    private String username;
    private String password;

    public User(Integer newUserId, String newFullName, String newUsername, String newPassword) {
        fullName = newFullName;
        username = newUsername;
        password = newPassword;
        userId = newUserId;
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean authenticateUser(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return this.username;
    }

    public int getId() {
        return this.userId;
    }

    public String setUsername(String newUsername) {
        return this.username = newUsername;
    }

    public String setPassword(String newPassword) {
        return this.password = newPassword;
    }
}
