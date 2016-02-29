/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author DrPoopAlotz
 */
public class Gateway {

    private int gatewayID;
    private Scanner scanner;
    private GateController gateController;
    private int stationID;
    // A gateway will always be in a train station
    private final String modeOfTransport = "TRAIN";

    public Gateway(int stationID) {
        this.scanner = new Scanner();
        this.gateController = new GateController();
        this.stationID = stationID;
    }

    public void PerformScanOut(TravelCard travelCard) throws Throwable {
        // The card id is read from the scanner and used to get the travel card
        // software object
        int cardID = scanner.read(travelCard);
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.getTravelCards().getTravelCardById(cardID);
        Zone zone = sys.getStationSystems().getStationSystemById(this.stationID).getZone();

        if (currCard == null) {
            this.reject();
        }

        Zone departureZone = currCard.getDepartureDetails().getZone();
        boolean hasPass = currCard.checkForPass(zone, departureZone);

        if (hasPass) {
            this.approve();
        } else {
            boolean hasPaid = false;

            SetOfTickets userTickets = currCard.userTickets();

            //Get journey price
            JourneyList list = new JourneyList();
            Journey journey = list.getJourneyAndPriceFromZones(departureZone, zone);

            Ticket currentTicket = currCard.userTickets().createNewTicket(journey, TypeEnums.TicketType.TRAIN, false);

            Transaction trans = new Transaction();
            hasPaid = trans.payForTicket(userTickets, currentTicket, currCard);

            if (hasPaid) {
                this.approve();
                currCard.setLastDepartedStationNull();
            } else {
                this.reject();
            }
        }
    }

    public void PerformScanIn(TravelCard travelCard) throws Throwable {
        int cardID = scanner.read(travelCard);
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.getTravelCards().getTravelCardById(cardID);

        if (currCard != null) {
            if (currCard.getBalance() > 0) {
                this.approve();
            } else {
                this.reject();
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
