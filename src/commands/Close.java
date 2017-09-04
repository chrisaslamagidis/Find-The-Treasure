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
public class Close implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();

        Room currentRoom = player.getLocation();
        Container container = currentRoom.findContainer(input);

        if (container != null && container.isOpen()) {
            container.setOpen(false);
            currentRoom.removeContainersInanimates(container.getInanimates());
            messages.add("You have closed the " + input);
        } else {
            if (container != null && container.isOpenable()) {
                messages.add("The " + input + " is already closed");
            } else {
                messages.add("You cannot close the " + input);
            }
        }
        return messages;
    }
}
