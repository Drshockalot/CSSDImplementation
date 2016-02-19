/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JoBa
 */
public class PortableReader {

    public Scanner scanner;

    public void readCard() throws Throwable {
        int cardID = scanner.read();
        TravelSystem sys = TravelSystem.getInstance();
        TravelCard currCard = sys.getTravelCard(cardID);

        if (currCard.checkForActivePass()) {

        }
    }
}
