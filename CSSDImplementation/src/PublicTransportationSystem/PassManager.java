/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author Drshockalotz
 */
public final class PassManager {

    private PassManager() {
    }

// Methods Begin
// <editor-fold>
    static public Pass generatePass(TypeEnums.PassType type) {
        return new Pass(type);
    }

// </editor-fold>
// Methods End
}
