/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 *
 * @author JackMcBlown
 */
public final class TypeEnums {

    private TypeEnums() {

    }

    public enum UserType {

        ADMIN, TRAVELINSPECTOR, USER
    };

    public enum TicketType {

        BUS, TRAIN
    };

    public enum PassType {

        BUSJOURNEY, BUSDAY, TRAINJOURNEY, TRAINDAY, BUSANDTRAINJOURNEY, BUSANDTRAINDAY
    };

}
