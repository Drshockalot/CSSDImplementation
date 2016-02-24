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
public class Zone implements Serializable {

    private static final long serialVersionUID = -4313904071667252251L;

    private String name;
    private int id;

    public Zone(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
