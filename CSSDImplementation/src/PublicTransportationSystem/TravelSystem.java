/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import Interfaces.SetOfUsersInterface;
import java.text.DecimalFormat;
import java.util.Date;

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

        //deserializeTickets();
        //deserializeTravelCard();
        initTravelCard();

        //deserializeStationSystems();
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
        initTickets();
        serializeTickets();
    }

    public void initTickets() {
        this.systemTickets.createNewTicket(this.systemJourneys.get(1), TypeEnums.TicketType.TRAIN, true, 1);
        this.systemTickets.createNewTicket(this.systemJourneys.get(2), TypeEnums.TicketType.TRAIN, true, 2);
    }

    public void initUsers() {
        SystemRole admin = new SystemRole(TypeEnums.UserType.ADMIN);
        SystemRole normalUser = new SystemRole(TypeEnums.UserType.USER);

        registerUser(1, "Test", "Loser", "User", "test@test.com", null, "password", normalUser);
        registerUser(2, "Chadwick", "Skimpson", "Freedom", "test@test.com", null, "FromAmericaWithLove", admin);
        registerUser(null, "Jonathon", "LoveTheDickSon", "JD", "test@test.co.uk", null, "p", admin);
        registerUser(null, "lil'", "Jack", "snapback", "stanky_memes@test.org", null, "ch ch ch checkin' it out", admin);
        registerUser(6, "Joshua", "Bates", "JoBa", "JoBa@uniqa.com", 1, "p", admin);
    }

    public void initTravelCard() {
        registerTravelCard(systemUsers.getUserById(6), 1.00f, 9.00f, 7.00f);
        registerTravelCard(systemUsers.getUserById(3), 1.00f, 9.00f, 7.00f);
        registerTravelCard(systemUsers.getUserById(2), 1.00f, 9.00f, 1.00f);
        registerTravelCard(systemUsers.getUserById(1), 1.00f, 9.00f, -1.00f);
        registerTravelCard(systemUsers.getUserById(4), 1.00f, 9.00f, 5.00f);
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

    public void registerTravelCard(User user, float discount, float dailyCap, float funds) {
        TravelCard newTravelCard = new TravelCard(systemTravelCards.getNextId(), user, discount, dailyCap);
        newTravelCard.addFunds(funds);
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

    public float convertToTwoDecimalPlaces(float number) {
        DecimalFormat decim = new DecimalFormat("0.00");
        return Float.parseFloat(decim.format(number));
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

    public void serializeTickets() {
        systemTickets.serializeTickets();
    }
//
//        public void serializeStationSystems() {
//        systemStationSystems.serializeStationSystems();
//    }

    public void serializeTravelCards() {
        //systemTravelCards.serializeTravelCards();
    }

    public void deserializeZones() throws ClassNotFoundException {
        systemZones = systemZones.deserializeZones();
    }

    public void deserializeStationSystems() throws ClassNotFoundException {
        //systemStationSystems = systemZones.deserializeStationSystems();
    }

    public void deserializeTravelCards() throws ClassNotFoundException {
        //systemTravelCards = systemTravelCards.deserializeTravelCards();
    }

    public void deserializeTickets() throws ClassNotFoundException {
        systemTickets = systemTickets.deserializeTickets();
    }

    public void deserializeJourneys() throws ClassNotFoundException {
        systemJourneys = systemJourneys.deserializeJourneys();
    }

    public void deserializeUsers() throws ClassNotFoundException {
        systemUsers = systemUsers.deserializeUsers();
    }
}
