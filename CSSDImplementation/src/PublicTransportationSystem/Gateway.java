/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author DrPoopAlotz
 */
public class Gateway implements Serializable {

    private static final long serialVersionUID = 3763011420896048629L;
    private int gatewayID;
    private Scanner scanner;
    private GateController gateController;
    private int stationID;
    // A gateway will always be in a train station
    private final String modeOfTransport = "TRAIN";

    public Gateway(int ID, int stationID) {
        this.gatewayID = ID;
        this.scanner = new Scanner();
        this.gateController = new GateController();
        this.stationID = stationID;
    }

    public boolean PerformScanOut(TravelCard travelCard) throws Throwable {
        // The card id is read from the scanner and used to get the travel card
        // software object
        int cardID = scanner.read(travelCard);
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.getTravelCards().getTravelCardById(cardID);
        StationSystem station = sys.getStationSystems().getStationSystemById(this.stationID);
        Zone zone = station.getZone();

        if (currCard == null) {
            this.reject();
            return false;
        }

        Zone departureZone = currCard.getDepartureDetails().getZone();
        boolean hasPass = currCard.checkForPass(zone, departureZone);
        // If the passenger does not have a journey pass
        if (!hasPass) {
            // Check for day pass
            Vector<TypeEnums.PassType> list = new Vector<>();
            list.add(TypeEnums.PassType.TRAINDAY);
            list.add(TypeEnums.PassType.BUSANDTRAINDAY);
            hasPass = currCard.checkForPass(list);
        }

        if (hasPass) {
            this.approve();
            // Reset the last departed station data to null, ready for the next
            // journey
            currCard.setLastDepartedStationNull();
            // Persist the change to the travel card
            sys.getTravelCards().serializeTravelCards();
            return true;
        } else {
            // Get the journey that the user has taken
            SetOfJourneys list = sys.getJourneys();
            Journey journey = list.getJourneyAndPriceFromZones(departureZone, zone);

            Ticket validUnusedTicket = null;
            // Get the unused tickets that the user owns
            SetOfTickets unusedTickets = TravelSystem.getInstance().getTickets().getUnusedTicketsForUser(currCard.getUser().getId());

            for (Ticket unusedTicket : unusedTickets) {
                if (unusedTicket.getJourney() == journey) {
                    // A ticket the user owns matches they journey they want to make
                    validUnusedTicket = unusedTicket;
                    break;
                }
            }
            // If a user has a ticket that could be used for this journey
            if (validUnusedTicket != null) {
                // Flag it as used and allow them through the gate
                validUnusedTicket.setUsed();
                // Persist the change to the ticket
                sys.getTickets().serializeTickets();
                return true;
            } else {
                // If they have no pass or a valid ticket, charge them for the
                // journey they have just made
                Ticket currentTicket = new Ticket(TravelSystem.getInstance().getTickets()
                        .getNextId(), TypeEnums.TicketType.TRAIN, journey, station.isPeak(), currCard.getUser().getId(), true);

                // Pay for the new ticket
                Transaction trans = new Transaction();
                boolean hasPaid = trans.payForTicket(currentTicket, currCard);
                // If payment was successful, allow them through the gate
                if (hasPaid) {
                    this.approve();
                    currCard.setLastDepartedStationNull();
                    // Persist the changes to the travel card
                    sys.getTravelCards().serializeTravelCards();
                    return true;
                } else {
                    // User must top-up their card
                    this.reject();
                    return false;
                }
            }
        }
    }

    public boolean PerformScanIn(TravelCard travelCard) throws Throwable {
        // Read the travel card
        int cardID = scanner.read(travelCard);
        TravelSystem sys = TravelSystem.getInstance();
        // Find the scanned card in the system
        TravelCard currCard = sys.getTravelCards().getTravelCardById(cardID);

        // If the current card has been found
        if (currCard != null) {
            // Make sure they have a positive balance
            if (currCard.getBalance() >= 0) {
                // Allow the user to pass the gate
                this.approve();
                // Set the users last departed station as the current one
                currCard.setLastDepartedStation(sys.getStationSystems().getStationSystemById(stationID));
                // Set the last departed date as today
                currCard.setLastDepartedTime(new Date());
                // Persist the changes to the travel card
                sys.getTravelCards().serializeTravelCards();
                return true;
            } else {
                this.reject();
                return false;
            }
        }
        return false;
    }

    public boolean PerformScanInTicket(Ticket ticket) throws Throwable {
        // Scan the ticket and retrieve the id
        int ticketID = scanner.readTicket(ticket);
        TravelSystem sys = TravelSystem.getInstance();
        // Get the ticket software object from the system based on the Id
        Ticket currentTicket = sys.getTickets().getTicketById(ticketID);

        if (currentTicket == null) {
            // if the ticket cannot be found, don't open the gate
            this.reject();
            return false;
        } else {
            this.approve();
            return true;
        }
    }

    public boolean PerformScanOutTicket(Ticket ticket) throws Throwable {
        // Scan the ticket and retrieve the id
        int ticketID = scanner.readTicket(ticket);
        TravelSystem sys = TravelSystem.getInstance();
        // Get the ticket software object from the system based on the Id
        Ticket currentTicket = sys.getTickets().getTicketById(ticketID);
        // Get the current zone we are in to compare with the ticket
        StationSystem station = sys.getStationSystems().getStationSystemById(this.stationID);
        Zone zone = station.getZone();

        if (currentTicket == null) {
            this.reject();
            return false;
        } else {
            // Check that the ticket arrival matches the actual arrival
            if (zone.getId() == currentTicket.getJourney().getEndZone().getId()) {
                // Flag the ticket as used and allow them through the gate
                currentTicket.setUsed();
                this.approve();
                // Persist the changes to the ticket
                sys.getTickets().serializeTickets();
                return true;
            } else {
                // The end zone of the ticket does not match the zone of the
                // gateway
                this.reject();
                return false;
            }
        }
    }

    public void approve() {
        gateController.open();
    }

    public void reject() {
        gateController.close();
    }

    public int getId() {
        return this.gatewayID;
    }
}
