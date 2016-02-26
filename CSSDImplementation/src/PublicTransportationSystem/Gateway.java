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

    private Scanner scanner;
    private GateController gateController;
    private int stationID;
    // A gateway will always be in a train station
    private final String modeOfTransport = "TRAIN";

    public void PerformScanOut() throws Throwable {
        int cardID = scanner.read();
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

            // TODO: TICKET TYPE NEEDS TO DEPEND UPON USER INPUT
            Ticket currentTicket = currCard.userTickets().createNewTicket(journey, TypeEnums.TicketType.TRAIN, false);

            Transaction trans = new Transaction();
            trans.payForTicket(userTickets, currentTicket, currCard);

            if (hasPaid) {
                this.approve();
                currCard.setLastDepartedStationNull();
            } else {
                this.reject();
            }
        }
    }

    public void PerformScanIn() throws Throwable {
        int cardID = scanner.read();
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
}
