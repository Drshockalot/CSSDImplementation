/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import Interfaces.SetOfUsersInterface;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
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
    private SetOfJourneys systemJourneys = new SetOfJourneys();
    private SetOfZones systemZones = new SetOfZones();
    private static TravelSystem INSTANCE;

    /**
     *
     */
    private TravelSystem() throws ClassNotFoundException {

        deserializeZones();
        deserializeUsers();
        deserializeJourneys();
        deserializeTravelCards();
        deserializeTickets();
        deserializeStationSystems();

        //initTravelCards();
        //initStationSystems();
        //deserializeTravelCard();
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
        systemTravelCards.removeAllElements();
        systemTickets.removeAllElements();
        systemStationSystems.removeAllElements();

        initZones();
        initUsers();
        initJourneys();
        //initTravelCards();
        initTickets();
        initStationSystems();

        serializeZones();
        serializeUsers();
        serializeJourneys();
        serializeTravelCards();
        serializeTickets();
        serializeStationSystems();

    }

    public void initTickets() {

        Ticket ticket = new Ticket(systemTickets.getNextId(), TypeEnums.TicketType.TRAIN, systemJourneys.firstElement(), true, 1, true);
        systemTickets.add(ticket);
        Ticket ticket2 = new Ticket(systemTickets.getNextId(), TypeEnums.TicketType.TRAIN, systemJourneys.firstElement(), true, 1, true);
        systemTickets.add(ticket2);
    }

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

    private TravelCard createTravelCardForUser(User user) {
        TravelCard travelCard = null;
        travelCard = new TravelCard(systemTravelCards.getNextId(), user, 0.00f, 8.00f);

        return travelCard;
    }

    public void initTravelCards() {
        registerTravelCard(systemUsers.getUserById(6), 1.00f, 9.00f, 7.00f);
        registerTravelCard(systemUsers.getUserById(3), 1.00f, 9.00f, 1.00f);
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
    public StationSystem registerStationSystem(String name, TypeEnums.StationType stationType, String location, GPSCoordinates gps, Zone zone, SetOfGateways scanners, boolean peak) {
        StationSystem newStationSystem = new StationSystem(systemStationSystems.getNextId(), name, stationType, location, gps, zone, scanners);

        systemStationSystems.add(newStationSystem);
        return newStationSystem;
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

    public SetOfJourneys getJourneys() {
        return systemJourneys;
    }

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

    public int gcd(int p, int q) {
        if (q == 0) {
            return p;
        } else {
            return gcd(q, p % q);
        }
    }

    public SetOfZones getZones() {
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

    public void serializeStationSystems() {
        systemStationSystems.serializeStationSystems();
    }

    public void serializeTravelCards() {
        systemTravelCards.serializeTravelCards();
    }

    public void deserializeZones() throws ClassNotFoundException {
        systemZones = systemZones.deserializeZones();
    }

    public void deserializeStationSystems() throws ClassNotFoundException {
        systemStationSystems = systemStationSystems.deserializeStationSystems();
    }

    public void deserializeTravelCards() throws ClassNotFoundException {
        systemTravelCards = systemTravelCards.deserializeTravelCards();
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
