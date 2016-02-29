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

    public Scanner scanner = new Scanner();

    public TravelCard readTravelCard(TravelCard travelCard) throws Throwable {
        int cardID = scanner.read(travelCard);
        return TravelSystem.getInstance().getTravelCards().getTravelCardById(cardID);
    }
}
