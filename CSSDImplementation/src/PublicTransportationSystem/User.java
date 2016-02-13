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
        if (newUserId == null) {
            userId = generateUserId();
        } else {
            userId = newUserId;
        }
        fullName = newFullName;
        username = newUsername;
        password = newPassword;
        userId = generateUserId();
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int generateUserId() {
        // When serializing we need to get the last id and increment onto it
        return 5;
    }

    public boolean authenticateUser(String password) {
        return this.password.equals(password);
    }

    public String getUsername() {
        return this.username;
    }

    public String setUsername(String newUsername) {
        return this.username = newUsername;
    }

    public String setPassword(String newPassword) {
        return this.password = newPassword;
    }
}
