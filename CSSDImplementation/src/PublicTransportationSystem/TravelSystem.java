/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import Interfaces.SetOfUsersInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        deserializeUsers();
        deserializeJourneys();
        deserializeZones();
        initTravelCard();
    }

    public static TravelSystem getInstance() throws Throwable {
        if (INSTANCE == null) {
            INSTANCE = new TravelSystem();
        }

        return INSTANCE;
    }

    public void resetData() {
        systemZones.removeAllElements();
        systemUsers.removeAllElements();
        systemJourneys.removeAllElements();
        initUsers();
        initTravelCard();
        serializeUsers();
        initZones();
        serializeZones();
        initJourneyList();
        serializeJourneys();
    }

    public void initUsers() {
        SystemRole newSysRole = new SystemRole(TypeEnums.UserType.ADMIN);
        SystemRole normalUser = new SystemRole(TypeEnums.UserType.USER);

        registerUser("Test", "Loser", "User", "test@test.com", "password", normalUser);
        registerUser("Chadwick", "Skimpson", "Freedom", "test@test.com", "FromAmericaWithLove", newSysRole);
        registerUser("Jonathon", "LoveTheDickSon", "JD", "test@test.co.uk", "p", newSysRole);
        registerUser("lil'", "Jack", "snapback", "test@test.org", "ch ch ch checkin' it out", newSysRole);
        registerUser("Joshua", "Bates", "JoBa", "test@test.fr", "p", newSysRole);
    }

    public void initTravelCard() {
        User user = null;
        float discount = 1.00f;
        float dailyCap = 9.00f;

        try {
            user = systemUsers.getUserById(1);
        } catch (Throwable ex) {
            Logger.getLogger(TravelSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        registerTravelCard(user, "test", discount, dailyCap);
    }

    public void initZones() {
        registerZone(1, "Zone A");
        registerZone(2, "Zone B");
        registerZone(3, "Zone C");
        registerZone(4, "Zone D");
        registerZone(5, "Zone E");
    }

    public void initJourneyList() {
        systemJourneys.removeAllElements();
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

    public void initStationSystems() {
        Zone zone = new Zone(3, "something");
        GPSCoordinates gps = new GPSCoordinates(11.21f, 41.21f);
        ArrayList<Gateway> scanners = new ArrayList<Gateway>(); // empty for now

        registerStationSystem("Kings Cross", "Train", "London", gps, zone, scanners, false);
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
        User newUser = new User(systemUsers.getNextId(), forename, surname, username, email, password, newSysRole, new Date());

        systemUsers.add(newUser);
    }

    public void registerZone(int id, String name) {
        Zone newZone = new Zone(id, name);

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
     * @param name
     * @param stationType
     * @param stationType
     * @param gps
     * @param zone
     * @param scanners
     * @param peak
     */
    public void registerStationSystem(String name, String stationType, String location, GPSCoordinates gps, Zone zone, ArrayList<Gateway> scanners, boolean peak) {
        StationSystem newStationSystem = new StationSystem(systemStationSystems.getNextId(), name, stationType, location, gps, zone, scanners, peak);

        systemStationSystems.add(newStationSystem);
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

    public TypeEnums.UserType[] getSystemRoles() {
        return TypeEnums.UserType.values();
    }

    public void serializeUsers() {
        systemUsers.serializeUsers();
    }

    public void serializeJourneys() {
        systemJourneys.serializeJourneys();
    }

    public void serializeZones() {
        systemZones.serializeZones();
    }

    public void deserializeZones() throws ClassNotFoundException {
        systemZones = systemZones.deserializeZones();
    }

    public void deserializeJourneys() throws ClassNotFoundException {
        systemJourneys = systemJourneys.deserializeJourneys();
    }

    public void deserializeUsers() throws ClassNotFoundException {
        systemUsers = systemUsers.deserializeUsers();
    }
}
