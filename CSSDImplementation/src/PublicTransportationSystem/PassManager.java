/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * Used to generated different pass types for Travel Card
 *
 * @author Drshockalotz
 */
public final class PassManager {

    private PassManager() {
    }

// Methods Begin
// <editor-fold>
    static public Pass generatePass(TypeEnums.PassType type) {
        // Generates a pass with a given type
        return new Pass(type);
    }

// </editor-fold>
// Methods End
}
