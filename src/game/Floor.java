/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Floor implements java.io.Serializable {

    private ArrayList<Room> rooms;

    /**
     * Empty constructor.
     */
    public Floor() {
        this.rooms = new ArrayList<>();
    }

    /**
     *
     * @return will return a list of rooms.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    /**
     *
     * @param rooms is used to set a list of rooms for the current floor.
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    /**
     *
     * @param roomToAdd is used to add a room to the current floor.
     */
    public void addRoom(Room roomToAdd) {
        rooms.add(roomToAdd);
    }

}
