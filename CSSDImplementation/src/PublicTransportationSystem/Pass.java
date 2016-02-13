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
public class Pass {

    private TypeEnums.PassType passType;
    private String purchaseTime;

    public Pass(TypeEnums.PassType passTypeEnum) {
        // this.ticketID = ticketID;  TODO: Needs to be generated
        this.purchaseTime = CurrentDateTime.get();
        SetPassType(passTypeEnum);
    }

    private void SetPassType(TypeEnums.PassType ticketTypeEnum) {
        this.purchaseTime = CurrentDateTime.get();
        this.passType = ticketTypeEnum;
    }
}
