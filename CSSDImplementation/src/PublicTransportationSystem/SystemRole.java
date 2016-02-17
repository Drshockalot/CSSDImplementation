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
public class SystemRole {

    String name;
    //PermissionList permissionList;

    public SystemRole(String name) {
        this.name = name;
//        this.permissionList = permissionList;
    }

    public boolean checkForPermissions(Permission permission) {
        return true;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAdmin() {
        return this.name.equals("ADMIN");
    }

}
