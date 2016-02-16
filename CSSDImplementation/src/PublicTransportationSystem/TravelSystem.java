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
        registerUser("Chadwick Skimspoon", "Freedom", "FromAmericaWithLove");
        registerUser("Jonathon LoveTheDickSon", "JD912", "password");
        registerUser("lil' Jack", "snapback", "ch ch ch checkin' it out");
        registerUser("Joshua Bates", "JoBa", "iDontKnowAboutYou");
    }

    /**
     *
     * @param userId
     * @param fullname
     * @param username
     * @param password
     */
    public static void registerUser(String fullname, String username, String password) {
        User newUser = new User(systemUsers.getNextId(), fullname, username, password);

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
}
