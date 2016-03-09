/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * System permissions, contains permission id and name/description
 *
 * @author JoBa
 */
public class Permission {

    int permissionId;
    String name;

    public Permission(String name, int newPermissionId) {
        this.name = name;
        this.permissionId = newPermissionId;
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
