/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PublicTransportationSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author JoBa
 */
public class SetOfUsers extends Vector<User> implements Serializable {

    private static final long serialVersionUID = 7292246324314723921L;

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

    public TypeEnums.UserType getUserSystemEnum(int userId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == userId) {
                return super.get(i).getSystemRole().getName();
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

    public SetOfUsers deserializeUsers() throws ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream("files/users.ser");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);

            SetOfUsers obj = (SetOfUsers) objIn.readObject();

            fileIn.close();
            objIn.close();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void serializeUsers() {
        try {
            FileOutputStream fileOut = new FileOutputStream("files/users.ser");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);

            objOut.close();
            fileOut.close();
            System.out.println("Serialised users");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
