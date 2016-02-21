/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfUsers extends Vector<User> implements Serializable {

    void addUser(User user) {
        super.add(user);
    }

    public User getUserByUsername(String username) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUsername().equals(username)) {
                return super.get(i);
            }
        }

        return null;
    }

    public User getUserById(int id) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == id) {
                return super.get(i);
            }
        }

        return null;
    }

    public int getNextId() {
        return super.isEmpty() ? 1 : super.lastElement().getId() + 1;
    }

    public void serializeUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/users.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            for (User user : this) {
                System.out.println(user.getUsername());
            }

            objOut.close();
            fileOut.close();
            System.out.println("Serialised users");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
