/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 *
 * @author JoBa
 */
public class Journey implements Serializable {

    private static final long serialVersionUID = 1045132110637312097L;

    private float offPeakPrice;
    private float onPeakPrice;
    private Zone startZone;
    private Zone endZone;

    public Journey(float offPeakPrice, float onPeakPrice, Zone startZone, Zone endZone) {
        this.offPeakPrice = offPeakPrice;
        this.onPeakPrice = onPeakPrice;
        this.startZone = startZone;
        this.endZone = endZone;
    }

    public float getOffPeakPrice() {
        return this.offPeakPrice;
    }

    public float getOnPeakPrice() {
        return this.onPeakPrice;
    }

    public float getPriceBasedOnPeak(boolean peak) {
        // Get the correct price depending on the state of peak
        if (peak) {
            return getOnPeakPrice();
        }

        return getOffPeakPrice();
    }

    public void setOffPeakPrice(float price) {
        this.offPeakPrice = price;
    }

    public void setOnPeakPrice(float price) {
        this.onPeakPrice = price;
    }

    public Zone getStartZone() {
        return this.startZone;
    }

    public Zone getEndZone() {
        return this.endZone;
    }
}
