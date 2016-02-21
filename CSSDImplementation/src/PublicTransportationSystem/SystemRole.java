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
public class SystemRole implements Serializable {

//    String name;
    TypeEnums.UserType name;
    //PermissionList permissionList;

    public SystemRole(TypeEnums.UserType name) {
        this.name = name;
//        this.permissionList = permissionList;
    }

    public boolean checkForPermissions(Permission permission) {
        return true;
    }

    public TypeEnums.UserType getName() {
        return this.name;
    }

    public boolean isAdmin() {
        return this.name == TypeEnums.UserType.ADMIN;
    }

    public boolean isTravelInspector() {
        return this.name == TypeEnums.UserType.TRAVELINSPECTOR;
    }

    public boolean isUser() {
        return this.name == TypeEnums.UserType.USER;
    }
}
