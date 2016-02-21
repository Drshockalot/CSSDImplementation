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

    public TravelCard readTravelCard() throws Throwable {
        int cardID = scanner.read();
        return TravelSystem.getInstance().getTravelCards().getTravelCardById(cardID);
    }
}
