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
public class Journey {

    private float price;

    public Journey(float price) {
        this.price = price;
    }

    public float GetPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
