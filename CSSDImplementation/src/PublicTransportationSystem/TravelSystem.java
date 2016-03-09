/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Acts as Database Mock for entire system. Used as an access point for most
 * Collection classes. Also used as access point for saving/loading data.
 *
 * @author JoBa
 */
public class TravelSystem {

    private SetOfUsers systemUsers = new SetOfUsers();
    private SetOfTravelCards systemTravelCards = new SetOfTravelCards();
    private SetOfTickets systemTickets = new SetOfTickets();
    private SetOfStationSystems systemStationSystems = new SetOfStationSystems();
    private SetOfJourneys systemJourneys = new SetOfJourneys();
    private SetOfZones systemZones = new SetOfZones();
    private static TravelSystem INSTANCE;

    /**
     *
     */
    private TravelSystem() throws ClassNotFoundException {
        // Deserializing the data from files
        deserializeZones();
        deserializeUsers();
        deserializeJourneys();
        deserializeTravelCards();
        deserializeTickets();
        deserializeStationSystems();
    }

    public static TravelSystem getInstance() throws Throwable {
        // Return the instance of travel system
        // if there isn't one, create one
        if (INSTANCE == null) {
            INSTANCE = new TravelSystem();
        }

        return INSTANCE;
    }

    public void resetData() {
        // Remove all data from collection classes
        systemZones.removeAllElements();
        systemUsers.removeAllElements();
        systemJourneys.removeAllElements();
        systemTravelCards.removeAllElements();
        systemTickets.removeAllElements();
        systemStationSystems.removeAllElements();

        // Initialize classes with data
        initZones();
        initUsers();
        initJourneys();
        initTickets();
        initStationSystems();

        // Serialize the data previously initialized
        serializeZones();
        serializeUsers();
        serializeJourneys();
        serializeTravelCards();
        serializeTickets();
        serializeStationSystems();

    }

    // Initilizes tickets
    public void initTickets() {
        Ticket ticket = new Ticket(systemTickets.getNextId(), TypeEnums.TicketType.TRAIN, systemJourneys.firstElement(), true, 1, true);
        systemTickets.add(ticket);
        Ticket ticket2 = new Ticket(systemTickets.getNextId(), TypeEnums.TicketType.TRAIN, systemJourneys.firstElement(), true, 1, true);
        systemTickets.add(ticket2);
    }

    // Initializes users
    public void initUsers() {
        SystemRole admin = new SystemRole(TypeEnums.UserType.ADMIN);
        SystemRole normalUser = new SystemRole(TypeEnums.UserType.USER);

        registerUser(1, "Test", "User", "TestUser", "test@test.com", null, "password", normalUser, "08-12-1992");
        registerUser(2, "Chadwick", "Skimpson", "Freedom", "test@testing.com", null, "FromAmericaWithLove", admin, "28-12-1992");
        registerUser(null, "Jonathon", "LoveTheDickSon", "JD", "test@test.co.uk", null, "p", admin, "09-12-1992");
        registerUser(null, "lil'", "Jack", "snapback", "test@test.org", null, "ch ch ch checkin' it out", admin, "07-05-1993");
        registerUser(6, "Joshua", "Bates", "JoBaUser", "test@test.fr", null, "p", normalUser, "28-08-1992");
        registerUser(null, "Joshua", "Bates", "JoBa", "test@test.fr", null, "p", admin, "28-08-1992");
        registerUser(null, "Wade", "Wilson", "Deadpool", "mercwithamouth@hotmail.com", null, "p", normalUser, "28-08-1992");
    }

    // Instantiates and returns a travel card
    private TravelCard createTravelCardForUser(User user) {
        TravelCard travelCard = null;
        travelCard = new TravelCard(systemTravelCards.getNextId(), user, 0.00f, 8.00f);

        return travelCard;
    }

    // Initialize Travel cards
    public void initTravelCards() {
        registerTravelCard(systemUsers.getUserById(6), 1.00f, 9.00f, 7.00f);
        registerTravelCard(systemUsers.getUserById(3), 1.00f, 9.00f, 1.00f);
        registerTravelCard(systemUsers.getUserById(2), 1.00f, 9.00f, 1.00f);
        registerTravelCard(systemUsers.getUserById(1), 1.00f, 9.00f, -1.00f);
        registerTravelCard(systemUsers.getUserById(4), 1.00f, 9.00f, 5.00f);
    }

    // Initialize Zones
    public void initZones() {
        registerZone(1, "Zone A");
        registerZone(2, "Zone B");
        registerZone(3, "Zone C");
        registerZone(4, "Zone D");
        registerZone(5, "Zone E");
    }

    // Initialize Journeys
    public void initJourneys() {
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

    // Initialize Station Systems
    public void initStationSystems() {
        Zone zone = this.systemZones.getZoneById(1);

        GPSCoordinates gps = new GPSCoordinates(11.21f, 41.21f);

        SetOfGateways gateways = new SetOfGateways();

        StationSystem newStationSystem = registerStationSystem(
                "Kings Cross", TypeEnums.StationType.TRAIN, "London", gps, zone, gateways, false);

        Gateway gateway = new Gateway(newStationSystem.getStationGateways().getNextId(), 1);
        newStationSystem.getStationGateways().add(gateway);

        zone = this.systemZones.getZoneById(2);

        gps = new GPSCoordinates(53.378471f, -1.462358f);
        gateways = new SetOfGateways();

        newStationSystem = registerStationSystem(
                "Sheffield Station", TypeEnums.StationType.BUS, "Sheffield", gps, zone, gateways, false);
        gateway = new Gateway(newStationSystem.getStationGateways().getNextId(), 2);
        newStationSystem.getStationGateways().add(gateway);

        zone = this.systemZones.getZoneById(3);

        gps = new GPSCoordinates(53.47740289999999f, -2.2309324999999944f);
        gateways = new SetOfGateways();

        newStationSystem = registerStationSystem(
                "Manchester Piccadilly", TypeEnums.StationType.TRAIN, "Manchester", gps, zone, gateways, false);
        gateway = new Gateway(newStationSystem.getStationGateways().getNextId(), 3);
        newStationSystem.getStationGateways().add(gateway);

        zone = this.systemZones.getZoneById(4);

        gps = new GPSCoordinates(53.314798f, -0.948438f);
        gateways = new SetOfGateways();

        newStationSystem = registerStationSystem(
                "Retford Station", TypeEnums.StationType.TRAIN, "Retford", gps, zone, gateways, false);
        gateway = new Gateway(newStationSystem.getStationGateways().getNextId(), 4);
        newStationSystem.getStationGateways().add(gateway);

        zone = this.systemZones.getZoneById(5);

        gps = new GPSCoordinates(53.522012f, -1.138745f);
        gateways = new SetOfGateways();

        newStationSystem = registerStationSystem(
                "Doncaster Station", TypeEnums.StationType.TRAIN, "Doncaster", gps, zone, gateways, false);
        gateway = new Gateway(newStationSystem.getStationGateways().getNextId(), 5);
        newStationSystem.getStationGateways().add(gateway);
    }

    /**
     * Registers a user
     *
     * @param id
     * @param forename
     * @param surname
     * @param username
     * @param email
     * @param password
     * @param newSysRole
     */
    public void registerUser(Integer id, String forename, String surname, String username, String email, Integer travelCardId, String password, SystemRole newSysRole, String dob) {
        // if no id is passed through, get next id
        if (id == null) {
            id = systemUsers.getNextId();
        }

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

        try {
            cal.setTime(sdf.parse(dob));
        } catch (ParseException ex) {
            Logger.getLogger(TravelSystem.class.getName()).log(Level.SEVERE, null, ex);
        }

        User newUser = new User(id, forename, surname, username, email, travelCardId, password, newSysRole, cal.getTime());

        if (newUser.getSystemRole().isUser()) {
            TravelCard travelCard = createTravelCardForUser(newUser);
            newUser.setTravelCardId(travelCard.getId());
            systemTravelCards.add(travelCard);
            systemTravelCards.serializeTravelCards();
        }

        systemUsers.add(newUser);
    }

    // Add a zone to the collection class
    public void registerZone(int id, String name) {
        Zone newZone = new Zone(id, name);

        systemZones.add(newZone);
    }

    // Add a journey to the journey collection class
    public void registerJourney(float price, float onPeakPrice, Zone startZone, Zone endZone) {
        Journey newJourney = new Journey(price, onPeakPrice, startZone, endZone);

        systemJourneys.add(newJourney);
    }

    // Add travel card to the collection class
    public void registerTravelCard(User user, float discount, float dailyCap, float funds) {
        TravelCard newTravelCard = new TravelCard(systemTravelCards.getNextId(), user, discount, dailyCap);
        newTravelCard.addFunds(funds);
        systemTravelCards.add(newTravelCard);
    }

    /**
     * Create and add station system to station system collection
     *
     * @param name
     * @param stationType
     * @param location
     * @param gps
     * @param zone
     * @param scanners
     * @param peak
     * @return station system
     */
    public StationSystem registerStationSystem(String name, TypeEnums.StationType stationType, String location, GPSCoordinates gps, Zone zone, SetOfGateways scanners, boolean peak) {
        StationSystem newStationSystem = new StationSystem(systemStationSystems.getNextId(), name, stationType, location, gps, zone, scanners);

        systemStationSystems.add(newStationSystem);
        return newStationSystem;
    }

    /**
     * Gets the set of users
     *
     * @return List of Users
     */
    public SetOfUsers getUsers() {
        return systemUsers;
    }

    // Converts a float to 2 dp and returns a string
    public String convertToTwoDecimalPlace(float number) {
        return String.format("%.2f", number);
    }

    // Converts a float to 2 dp and returns a float
    public float convertToTwoDecimalPlaces(float number) {
        DecimalFormat decim = new DecimalFormat("0.00");
        return Float.parseFloat(decim.format(number));
    }

    // Returns the set of travel cards
    public SetOfTravelCards getTravelCards() {
        return systemTravelCards;
    }

    // Returns the set of station systems
    public SetOfStationSystems getStationSystems() {
        return systemStationSystems;
    }

    // Returns the set of journeys
    public SetOfJourneys getJourneys() {
        return systemJourneys;
    }

    // Calculates a ratio from two integers
    public int[] ratio(int a, int b) {
        final int gcd = gcd(a, b);
        int[] ratio = new int[2];

        if (a > 0) {
            ratio[0] = a / gcd;
        }
        if (b > 0) {
            ratio[1] = b / gcd;
        }

        return ratio;
    }

    // Helps to calculate ratio
    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    // Get the set of zones
    public SetOfZones getZones() {
        return systemZones;
    }

    // Gets the set of tickets
    public SetOfTickets getTickets() {
        return systemTickets;
    }

    // Gets the user system roles
    public TypeEnums.UserType[] getSystemRoles() {
        return TypeEnums.UserType.values();
    }

    // Serialises users
    public void serializeUsers() {
        systemUsers.serializeUsers();
    }

    // Serialises journeys
    public void serializeJourneys() {
        systemJourneys.serializeJourneys();
    }

    // Serialises zones
    public void serializeZones() {
        systemZones.serializeZones();
    }

    // Serialises tickets
    public void serializeTickets() {
        systemTickets.serializeTickets();
    }

    // Serialises station systems
    public void serializeStationSystems() {
        systemStationSystems.serializeStationSystems();
    }

    // Serialises travel cards
    public void serializeTravelCards() {
        systemTravelCards.serializeTravelCards();
    }

    // Deserialises zones
    public void deserializeZones() throws ClassNotFoundException {
        systemZones = systemZones.deserializeZones();
    }

    // Deserialises station systems
    public void deserializeStationSystems() throws ClassNotFoundException {
        systemStationSystems = systemStationSystems.deserializeStationSystems();
    }

    // Deserialises travel cards
    public void deserializeTravelCards() throws ClassNotFoundException {
        systemTravelCards = systemTravelCards.deserializeTravelCards();
    }

    // Deserialises tickets
    public void deserializeTickets() throws ClassNotFoundException {
        systemTickets = systemTickets.deserializeTickets();
    }

    // Deserialises journeys
    public void deserializeJourneys() throws ClassNotFoundException {
        systemJourneys = systemJourneys.deserializeJourneys();
    }

    // Deserialises users
    public void deserializeUsers() throws ClassNotFoundException {
        systemUsers = systemUsers.deserializeUsers();
    }
}
