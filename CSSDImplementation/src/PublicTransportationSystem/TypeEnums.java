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

    // A collection of Enums used throughout the system, used to identify the type
    // of different objects
    // i.e: User, Ticket, Pass and Station types
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

    public enum StationType {

        BUS, TRAIN, SPACE
    };

}
