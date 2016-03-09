/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

/**
 * A collection of Enums used throughout the system, used to identify the type
 * of different objects i.e: User, Ticket, Pass and Station types
 *
 * @author JackMcGlone
 */
public final class TypeEnums {

    private TypeEnums() {
    }

    /**
     * System user types available: ADMIN, TRAVELINSPECTOR, USER
     *
     */
    public enum UserType {

        ADMIN, TRAVELINSPECTOR, USER
    };

    /**
     * System ticket types available: BUS, TRAIN
     *
     */
    public enum TicketType {

        BUS, TRAIN
    };

    /**
     * System pass types available: BUSJOURNEY, BUSDAY, TRAINJOURNEY, TRAINDAY,
     * BUSANDTRAINJOURNEY, BUSANDTRAINDAY
     *
     */
    public enum PassType {

        BUSJOURNEY, BUSDAY, TRAINJOURNEY, TRAINDAY, BUSANDTRAINJOURNEY, BUSANDTRAINDAY
    };

    /**
     * System station types available: BUS, TRAIN, SPACE
     *
     */
    public enum StationType {

        BUS, TRAIN, SPACE
    };

}
