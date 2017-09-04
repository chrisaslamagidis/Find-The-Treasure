/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import game.Player;
import game.Room;
import java.util.ArrayList;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class SaveData implements java.io.Serializable {

    Player player = new Player();

    /**
     *
     * @param detective
     * @param rooms
     */
    public void save(Player detective, ArrayList<Room> rooms) {
        player = detective;

    }

    /**
     *
     * @param detective
     * @param rooms
     */
    public void load(Player detective, ArrayList<Room> rooms) {
        detective.setLocation(player.getLocation());
        detective.setInanimates(player.getInanimates());

    }

}
