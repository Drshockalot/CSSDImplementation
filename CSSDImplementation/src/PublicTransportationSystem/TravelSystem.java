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

    private SetOfUsers systemUsers = new SetOfUsers();
    private SetOfTravelCards systemTravelCards = new SetOfTravelCards();
    private SetOfStationSystems systemStationSystems = new SetOfStationSystems();
    private JourneyList systemJourneys = new JourneyList();
    private ZoneList systemZones = new ZoneList();
    private static TravelSystem INSTANCE;

    /**
     *
     */
    private TravelSystem() throws ClassNotFoundException {
        //initUsers();
        deserializeUsers();
        initZones();
        initJourneyList();
    }

    public static TravelSystem getInstance() throws Throwable {
        if (INSTANCE == null) {
            INSTANCE = new TravelSystem();
        }

        return INSTANCE;
    }

    public void initUsers() {
        SystemRole newSysRole = new SystemRole("ADMIN");
        registerUser("Test", "Loser", "User", "test@test.com", "password", newSysRole);
        registerUser("Chadwick", "Skimpson", "Freedom", "test@test.com", "FromAmericaWithLove", newSysRole);
        registerUser("Jonathon", "LoveTheDickSon", "JD", "test@test.co.uk", "p", newSysRole);
        registerUser("lil'", "Jack", "snapback", "test@test.org", "ch ch ch checkin' it out", newSysRole);
        registerUser("Joshua", "Bates", "JoBa", "test@test.fr", "p", newSysRole);
    }

    public void initZones() {
        registerZone("Zone A", 1);
        registerZone("Zone B", 2);
        registerZone("Zone C", 3);
        registerZone("Zone D", 4);
        registerZone("Zone E", 5);
    }

    public void initJourneyList() {
        registerJourney((float) 1.99, (float) 2.46, systemZones.getZoneById(1), systemZones.getZoneById(1));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(1), systemZones.getZoneById(2));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(1), systemZones.getZoneById(3));
        registerJourney((float) 4.99, (float) 5.46, systemZones.getZoneById(1), systemZones.getZoneById(4));
        registerJourney((float) 5.99, (float) 6.46, systemZones.getZoneById(1), systemZones.getZoneById(5));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(2), systemZones.getZoneById(1));
        registerJourney((float) 1.99, (float) 2.46, systemZones.getZoneById(2), systemZones.getZoneById(2));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(2), systemZones.getZoneById(3));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(2), systemZones.getZoneById(4));
        registerJourney((float) 4.99, (float) 5.46, systemZones.getZoneById(2), systemZones.getZoneById(5));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(3), systemZones.getZoneById(1));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(3), systemZones.getZoneById(2));
        registerJourney((float) 1.99, (float) 2.46, systemZones.getZoneById(3), systemZones.getZoneById(3));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(3), systemZones.getZoneById(4));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(3), systemZones.getZoneById(5));
        registerJourney((float) 4.99, (float) 5.46, systemZones.getZoneById(4), systemZones.getZoneById(1));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(4), systemZones.getZoneById(2));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(4), systemZones.getZoneById(3));
        registerJourney((float) 1.99, (float) 2.46, systemZones.getZoneById(4), systemZones.getZoneById(4));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(4), systemZones.getZoneById(5));
        registerJourney((float) 5.99, (float) 6.46, systemZones.getZoneById(5), systemZones.getZoneById(1));
        registerJourney((float) 4.99, (float) 5.46, systemZones.getZoneById(5), systemZones.getZoneById(2));
        registerJourney((float) 3.99, (float) 4.46, systemZones.getZoneById(5), systemZones.getZoneById(3));
        registerJourney((float) 2.99, (float) 3.46, systemZones.getZoneById(5), systemZones.getZoneById(4));
        registerJourney((float) 1.99, (float) 2.46, systemZones.getZoneById(5), systemZones.getZoneById(5));

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
    public void registerUser(String forename, String surname, String username, String email, String password, SystemRole newSysRole) {
        User newUser = new User(systemUsers.getNextId(), forename, surname, username, email, password, newSysRole);

        systemUsers.add(newUser);
    }

    public void registerZone(String name, int id) {
        Zone newZone = new Zone(name, id);

        systemZones.add(newZone);
    }

    public void registerJourney(float price, float onPeakPrice, Zone startZone, Zone endZone) {
        Journey newJourney = new Journey(price, onPeakPrice, startZone, endZone);

        systemJourneys.add(newJourney);
    }

    public void registerTravelCard(User user, String cardType, float discount, float dailyCap) {
        TravelCard newTravelCard = new TravelCard(systemTravelCards.nextId(), user, cardType, discount, dailyCap);

        systemTravelCards.add(newTravelCard);
    }

    /**
     *
     * @return List of Users
     */
    public SetOfUsers getUsers() {
        return systemUsers;
    }

    public SetOfTravelCards getTravelCards() {
        return systemTravelCards;
    }

    public SetOfStationSystems getStationSystems() {
        return systemStationSystems;
    }

    public JourneyList getJourneys() {
        return systemJourneys;
    }

    public ZoneList getZones() {
        return systemZones;
    }

    public void serializeUsers() {
        systemUsers.serializeUsers();
    }

    public void deserializeUsers() throws ClassNotFoundException {
        systemUsers = systemUsers.deserializeUsers();
    }
}
