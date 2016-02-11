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
        User user = new User(0,"Chadwick Skimspoon", "Freedom", "FromAmericaWithLove");
        systemUsers.add(user);      
        user = new User(1,"Jonathon LoveTheDickSon", "JD912", "LiverpoolFCTopSupporter");
        systemUsers.add(user);
        user = new User(2,"Jack McGlone Cosby", "billCosbySavedMe", "WhenIGetThatFeeling");
        systemUsers.add(user);
        user = new User(3,"Joshua Bates", "JoBa", "iDontKnowAboutYou");
        systemUsers.add(user);
    }

    public SetOfUsers getUsers()
    {
        return systemUsers;
    }
}
