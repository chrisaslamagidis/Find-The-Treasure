/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.ArrayList;
import game.Room;
import game.Player;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class LookAround implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        Room currentRoom = player.getLocation();

        return currentRoom.lookAround();
    }

}
