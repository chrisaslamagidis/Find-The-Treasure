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
public class GoTo implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();
        
        Room currentRoom = player.getLocation();

        if (input.equals(currentRoom.getName())) {
            messages.add("You are already in the " + currentRoom.getName() + ", try something else.");
        } else {
            Room changedRoom = currentRoom.findMatch(input);
            if (changedRoom != null && changedRoom.isLocked() == false) {
                player.setLocation(changedRoom);
                messages.add("You are in the " + changedRoom.getName());
            } else {
                messages.add("You cannot access the " + input + ", try something else.");
            }
        }

        return messages;
    }
}
