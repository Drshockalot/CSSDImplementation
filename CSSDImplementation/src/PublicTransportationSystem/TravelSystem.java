/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import Interfaces.SetOfUsersInterface;

/**
 *
 * @author JoBa
 */
public class TravelSystem implements SetOfUsersInterface {

    private static SetOfUsers systemUsers = new SetOfUsers();
    private static SetOfTravelCards travelCards = new SetOfTravelCards();
    private static TravelSystem INSTANCE;

    /**
     *
     */
    private TravelSystem() {
    }

    public static TravelSystem getInstance() throws Throwable {
        if (INSTANCE == null) {
            INSTANCE = new TravelSystem();
        }

        return INSTANCE;
    }

    public static void initUsers() {
        SystemRole newSysRole = new SystemRole("ADMIN");
        registerUser("Chadwick", "Skimpson", "Freedom", "test@test.com", "FromAmericaWithLove", newSysRole);
        registerUser("Jonathon", "LoveTheDickSon", "JD912", "test@test.co.uk", "password", newSysRole);
        registerUser("lil'", "Jack", "snapback", "test@test.org", "ch ch ch checkin' it out", newSysRole);
        registerUser("Joshua", "Bates", "JoBa", "test@test.fr", "iDontKnowAboutYou", newSysRole);
    }

    /**
     *
     * @param forename
     * @param surname
     * @param username
     * @param email
     * @param password
     * @param newSysRole
     */
    public static void registerUser(String forename, String surname, String username, String email, String password, SystemRole newSysRole) {
        User newUser = new User(systemUsers.getNextId(), forename, surname, username, email, password, newSysRole);

        systemUsers.add(newUser);
    }

    /**
     *
     * @return List of Users
     */
    public SetOfUsers getUsers() {
        return systemUsers;
    }

    public SetOfTravelCards getTravelCards() {
        return travelCards;
    }

    public TravelCard GetTravelCard(int id) {
        return travelCards.getTravelCardById(id);
    }

    public User getUser(String username, String password) {
        User user = systemUsers.getUserByUsername(username);

        if (user != null) {
            if (user.authenticateUser(password)) {
                return user;
            }
            return null;
        }

        return null;
    }
}
