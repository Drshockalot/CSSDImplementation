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
public class TravelSystem {

    private static SetOfUsers systemUsers = new SetOfUsers();
    private static TravelSystem travelSystem = null;

    /**
     *
     */
    private TravelSystem() {
        User user = new User(0, "Chadwick Skimspoon", "Freedom", "FromAmericaWithLove");
        systemUsers.add(user);
        user = new User(1, "Jonathon LoveTheDickSon", "JD912", "password");
        systemUsers.add(user);
        user = new User(2, "lil' Jack", "snapback", "ch ch ch checkin' it out");
        systemUsers.add(user);
        user = new User(3, "Joshua Bates", "JoBa", "iDontKnowAboutYou");
        systemUsers.add(user);
    }

    public static TravelSystem getInstance() {
        if (travelSystem == null) {
            travelSystem = new TravelSystem();
        }

        return travelSystem;
    }

    /**
     *
     * @param fullname
     * @param username
     * @param password
     */
    public static void registerUser(String fullname, String username, String password) {
        User newUser = new User(5, fullname, username, password);

        systemUsers.add(newUser);
    }

    /**
     *
     * @return List of Users
     */
    public static SetOfUsers getUsers() {
        return systemUsers;
    }
}
