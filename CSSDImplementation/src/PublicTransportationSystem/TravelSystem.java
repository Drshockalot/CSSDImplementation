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
        User user = new User(0, "Chadwick Skimspoon", "Freedom", "FromAmericaWithLove");
        systemUsers.add(user);
        user = new User(1, "Jonathon LoveTheDickSon", "JD912", "password");
        systemUsers.add(user);
        user = new User(2, "lil' Jack", "snapback", "ch ch ch checkin' it out");
        systemUsers.add(user);
        user = new User(3, "Joshua Bates", "JoBa", "iDontKnowAboutYou");
        systemUsers.add(user);
    }

    /**
     *
     * @param userId
     * @param fullname
     * @param username
     * @param password
     */
    public static void registerUser(int userId, String fullname, String username, String password) {
        User newUser = new User(userId, fullname, username, password);

        systemUsers.add(newUser);
    }

    /**
     *
     * @return List of Users
     */
    public SetOfUsers getUsers() {
        return systemUsers;
    }
}
