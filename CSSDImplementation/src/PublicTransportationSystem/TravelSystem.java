/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import Interfaces.SetOfUsersInterface;
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
    private SetOfTickets systemTickets = new SetOfTickets();
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
        initStationSystems();
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

        registerUser(1, "Test", "Loser", "User", "test@test.com", null, "password", normalUser);
        registerUser(2, "Chadwick", "Skimpson", "Freedom", "test@test.com", null, "FromAmericaWithLove", newSysRole);
        registerUser(null, "Jonathon", "LoveTheDickSon", "JD", "test@test.co.uk", null, "p", newSysRole);
        registerUser(null, "lil'", "Jack", "snapback", "test@test.org", null, "ch ch ch checkin' it out", newSysRole);
        registerUser(6, "Joshua", "Bates", "JoBa", "test@test.fr", 1, "p", newSysRole);
    }

    public void initTravelCard() {
        User user = null;
        float discount = 1.00f;
        float dailyCap = 9.00f;

        try {
            user = systemUsers.getUserById(6);
        } catch (Throwable ex) {
            Logger.getLogger(TravelSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        registerTravelCard(user, "test", discount, dailyCap);

        user = systemUsers.getUserById(3);
        registerTravelCard(user, "nothing", discount, dailyCap);
        registerTravelCard(systemUsers.getUserById(2), "nothing", discount, dailyCap);
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
        Zone zone = this.systemZones.getZoneById(1);

        GPSCoordinates gps = new GPSCoordinates(11.21f, 41.21f);
        SetOfGateways gateways = new SetOfGateways(); // empty for now
        gateways.addGateway(1);
        gateways.addGateway(1);
        gateways.addGateway(1);

        registerStationSystem("Kings Cross", "Train", "London", gps, zone, gateways, false);

        zone = this.systemZones.getZoneById(2);

        gps = new GPSCoordinates(53.378471f, -1.462358f);
        gateways = new SetOfGateways();
        gateways.addGateway(2);
        gateways.addGateway(2);
        gateways.addGateway(2);

        registerStationSystem("Sheffield Station", "Train", "Sheffield", gps, zone, gateways, false);

        zone = this.systemZones.getZoneById(3);

        gps = new GPSCoordinates(53.47740289999999f, -2.2309324999999944f);
        gateways = new SetOfGateways();
        gateways.addGateway(3);
        gateways.addGateway(3);
        gateways.addGateway(3);

        registerStationSystem("Manchester Piccadilly", "Train", "Manchester", gps, zone, gateways, false);
    }

    /**
     *
     * @param id
     * @param forename
     * @param surname
     * @param username
     * @param email
     * @param password
     * @param newSysRole
     */
    public void registerUser(Integer id, String forename, String surname, String username, String email, Integer travelCardId, String password, SystemRole newSysRole) {
        // if no id is passed through, get next id
        if (id == null) {
            id = systemUsers.getNextId();
        }
        User newUser = new User(id, forename, surname, username, email, travelCardId, password, newSysRole, new Date());

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
        TravelCard newTravelCard = new TravelCard(systemTravelCards.getNextId(), user, cardType, discount, dailyCap);
        newTravelCard.addFunds(7.00f);
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
    public void registerStationSystem(String name, String stationType, String location, GPSCoordinates gps, Zone zone, SetOfGateways scanners, boolean peak) {
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

    public String convertToTwoDecimalPlace(float number) {
        return String.format("%.2f", number);
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

    public SetOfTickets getTickets() {
        return systemTickets;
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
