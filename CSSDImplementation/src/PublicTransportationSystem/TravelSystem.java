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
public class TravelSystem {
    private SetOfUsers systemUsers = new SetOfUsers();
    
    public TravelSystem() 
    {
        User user = new User("Bill Cosby", "Test", "password");
        systemUsers.add(user);
    }

    public SetOfUsers getUsers()
    {
        return systemUsers;
    }
}
