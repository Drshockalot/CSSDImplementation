/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Date;
import java.util.Vector;

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
        Zone zone = sys.getStationSystems().getStationSystemById(this.stationID).getZone();

        if (currCard == null) {
            this.reject();
            return false;
        }

        Zone departureZone = currCard.getDepartureDetails().getZone();
        boolean hasPass = currCard.checkForPass(zone, departureZone);
        if (!hasPass) {
            Vector<TypeEnums.PassType> list = new Vector<>();
            list.add(TypeEnums.PassType.TRAINDAY);
            list.add(TypeEnums.PassType.BUSANDTRAINDAY);
            hasPass = currCard.checkForPass(list);
        }

        if (hasPass) {
            this.approve();
            return true;
        } else {
            boolean hasPaid = false;

            //Get journey price
            JourneyList list = sys.getJourneys();
            Journey journey = list.getJourneyAndPriceFromZones(departureZone, zone);

            Ticket currentTicket = TravelSystem.getInstance().getTickets()
                    .createNewTicket(journey, TypeEnums.TicketType.TRAIN, false, currCard.getUser().getId());

            Transaction trans = new Transaction();
            hasPaid = trans.payForTicket(currentTicket, currCard);

            if (hasPaid) {
                this.approve();
                currCard.setLastDepartedStationNull();
                return true;
            } else {
                this.reject();
                return false;
            }
        }
    }

    public boolean PerformScanIn(TravelCard travelCard) throws Throwable {
        int cardID = scanner.read(travelCard);
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.getTravelCards().getTravelCardById(cardID);

        if (currCard != null) {
            if (currCard.getBalance() >= 0) {
                this.approve();
                currCard.setLastDepartedStation(sys.getStationSystems().getStationSystemById(stationID));
                currCard.setLastDepartedTime(new Date());
                return true;
            } else {
                this.reject();
                return false;
            }
        }
        return false;
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
