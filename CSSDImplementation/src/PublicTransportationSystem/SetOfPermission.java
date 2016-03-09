/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Vector;

/**
 * Container class for permissions
 *
 * @author JoBa
 */
public class SetOfPermission extends Vector<Permission> {

    void addPermission(Permission permission) {
        super.add(permission);
    }

    void removePermission(Permission permission) {
        super.remove(permission);
    }

    public boolean searchPermissionList(int permissionId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == permissionId) {
                return true;
            }
        }

        return false;
    }
}
