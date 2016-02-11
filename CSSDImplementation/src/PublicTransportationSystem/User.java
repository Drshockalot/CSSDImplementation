/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.util.Random;

/**
 *
 * @author JoBa
 */
public class User {
    private String fullName;
    private int userId;
    private String username;
    private String password;
    
    public User(String newFullName, String newUsername, String newPassword)
    {
        fullName = newFullName;
        username = newUsername;
        password = newFullName;
        userId = GenerateUserId();
    }

    private int GenerateUserId() 
    {
        // When serializing we need to get the last id and increment onto it
        return 1;
    }
}
