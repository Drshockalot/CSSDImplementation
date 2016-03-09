/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Contains information for user
 *
 * @author JoBa
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1326120471038901083L;

    private String forename;
    private String surname;
    private int userId;
    private String username;
    private String password;
    private SystemRole userRole;
    private int travelCardId;
    private String email;
    private Date dateOfBirth;

    public User(Integer newUserId, String newForename, String newSurname, String newUsername, String newEmail, Integer newTravelCardId, String newPassword, SystemRole newUserRole, Date dob) {
        forename = newForename;
        surname = newSurname;
        username = newUsername;
        password = newPassword;
        userId = newUserId;
        userRole = newUserRole;

        // -1 is added to signify that a user doesn't have a travel card
        if (newTravelCardId == null || newTravelCardId < 0) {
            travelCardId = -1;
        } else {
            travelCardId = newTravelCardId;
        }

        email = newEmail;
        dateOfBirth = dob;
    }

    @Override
    public String toString() {
        return this.userId + " - " + this.forename + " " + this.surname;
    }

    // checks user provided against stored password, called from login
    public boolean authenticateUser(String password) {
        return this.password.equals(password);
    }

    // <editor-fold desc="Getters">
    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public SystemRole getSystemRole() {
        return this.userRole;
    }

    public String getUsername() {
        return this.username;
    }

    public int getTravelCardId() {
        return this.travelCardId;
    }

    public int getId() {
        return this.userId;
    }

    public String getEmail() {
        return this.email;
    }

    public Date getDob() {
        return this.dateOfBirth;
    }

    public String getDobFormatted() {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(this.dateOfBirth);
    }

    // overload for just time/date
    public String getDobFormatted(String formatType) {
        // defaults to date unless time is explictly passed
        if (formatType.equals("time")) {
            return new SimpleDateFormat("HH:mm:ss").format(this.dateOfBirth);
        }
        return new SimpleDateFormat("dd-MM-yyyy").format(this.dateOfBirth);

    }

    public String getForename() {
        return this.forename;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    // </editor-fold>
    // <editor-fold desc="Setters">
    public void setUsername(String newUsername) {
        this.username = newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public void setForename(String newForename) {
        this.forename = newForename;
    }

    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }

    public void setUserRole(SystemRole newUserRole) {
        this.userRole = newUserRole;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public void setDob(Date newDob) {
        this.dateOfBirth = newDob;
    }

    public void setTravelCardId(int travelCardId) {
        this.travelCardId = travelCardId;
    }

    // </editor-fold>
}
