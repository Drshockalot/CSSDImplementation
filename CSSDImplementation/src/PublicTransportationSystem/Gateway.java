/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author Drshockalotz
 */
public class Gateway {

    private Scanner scanner;
    private GateController gateController;
    private int stationID;

    public void DetectCard() throws Throwable {
        int cardID = scanner.read();
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.GetTravelCard(cardID);
        Zone zone = sys.GetStationSystem(this.stationID).getZone();
        Zone departureZone = currCard.GetDepartureDetails().getZone();
        boolean hasPass = currCard.checkForPass(zone, departureZone);

        if (hasPass) {
            this.approve();
        } else {
            boolean hasPaid = false;

            TicketList userTickets = currCard.userTickets();

            if (hasPaid) {
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
