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
public class Permission {

    int permissionId;
    String name;

    public Permission(String name) {
        this.name = name;
        this.permissionId = 1; // This needs changing to get latest++
    }

    public int getId() {
        return this.permissionId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
