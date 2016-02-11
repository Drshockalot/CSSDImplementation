/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.ArrayList;

/**
 *
 * @author JoBa
 */
public class SetOfUsers extends ArrayList<User> {
    
    void addUser(User user)
    {
        super.add(user);
    }
    
    public User getUserByUsername(String username)
    {
        for(int i = 0; i < super.size(); i++)
        {
            if (super.get(i).getUsername().equals(username))
            {
                return super.get(i);
            }
        }
        
        return null;
    }
}
