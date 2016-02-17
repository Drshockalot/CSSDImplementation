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

    private String forename;
    private String surname;
    private int userId;
    private String username;
    private String password;
    private SystemRole userRole;
    private int travelCard;
    private String email;

    public User(Integer newUserId, String newForename, String newSurname, String newUsername, String newEmail, String newPassword, SystemRole newUserRole) {
        forename = newForename;
        surname = newSurname;
        username = newUsername;
        password = newPassword;
        userId = newUserId;
        userRole = newUserRole;
        travelCard = 1;
        email = newEmail;
    }

    User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean authenticateUser(String password) {
        return this.password.equals(password);
    }

    public SystemRole getSystemRole() {
        return this.userRole;
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
