/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import game.Player;
import game.Room;
import java.util.ArrayList;
import things.Container;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Open implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();
        
        Room currentRoom = player.getLocation();
        Container container = currentRoom.findContainer(input);

        if (container != null && !container.isOpen() && container.isOpenable()) {
            container.setOpen(true);
            currentRoom.addContainersInanimates(container.getInanimates());
            messages.add("Hurray! You have opened the " + input);
        } else {
            if (container != null && container.isOpenable()) {
                messages.add("The " + input + " is already open");
            } else {
                messages.add("You cannot open the " + input);
            }
        }
        return messages;
    }
}
