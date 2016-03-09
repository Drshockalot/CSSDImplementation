/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * Holds an instance of scanner. Has method to read user travel cards
 *
 * @author JoBa
 */
public class PortableReader {

    public Scanner scanner = new Scanner();

    public TravelCard readTravelCard(TravelCard travelCard) throws Throwable {
        // Simulate the reading of a travel card
        int cardID = scanner.read(travelCard);
        // Get the travel card from the system and return it
        return TravelSystem.getInstance().getTravelCards().getTravelCardById(cardID);
    }
}
