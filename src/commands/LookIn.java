/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.ArrayList;
import game.Room;
import game.Player;
import things.Container;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class LookIn implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();

        Room currentRoom = player.getLocation();
        Container container = currentRoom.findContainer(input);

        if (container != null && container.isOpen()) {
            container.getInanimates().forEach((inanimate) -> {
                messages.add(inanimate.getName());
            });
        } else {
            if (container != null && container.isOpenable()) {
                messages.add("You need to open it first.");
            } else if (container != null && !container.isOpenable()) {
                messages.add("Are you really trying to look in the " + input + "?");
            } else {
                messages.add("No such thing");
            }
        }
        return messages;
    }
}
