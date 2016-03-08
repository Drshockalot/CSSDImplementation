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

    // search through set of users and returns a list of any members that
    // contain the passed through String
    public SetOfUsers searchUsersByUsername(String username) {
        SetOfUsers searchResult = new SetOfUsers();
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUsername().equals(username)) {
                searchResult.addUser(super.get(i));
            }
        }
        return searchResult;
    }

    // search through set of users and returns single members that
    // matches the passed through username, returns null if not found
    public User getUserByUsername(String username) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getUsername().equals(username)) {
                return super.get(i);
            }
        }

        return null;
    }

    // search through set of users and returns single members that
    // matches the passed through email, ignoring letter-casing,
    // returns null if not found
    public User getUserByEmail(String email) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getEmail().equalsIgnoreCase(email)) {
                return super.get(i);
            }
        }
        return null;
    }

    // search through set of users and returns user role when
    // userId matches, returns null if not found
    public TypeEnums.UserType getUserSystemEnum(int userId) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == userId) {
                return super.get(i).getSystemRole().getName();
            }
        }

        return null;
    }

    // search through set of users and returns user with matching userId
    // returns null if not found
    public User getUserById(int id) {
        for (int i = 0; i < super.size(); i++) {
            if (super.get(i).getId() == id) {
                return super.get(i);
            }
        }

        return null;
    }

    // get next available ID, used when registering/creating user
    public int getNextId() {
        // if set is empty, return 1, else return next id
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
