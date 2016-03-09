/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.Serializable;

/**
 * Class used to identify user type, contains boolean functions to check user
 * type values
 *
 * @author JoBa
 */
public class SystemRole implements Serializable {

    private static final long serialVersionUID = -3633009533633799965L;

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
