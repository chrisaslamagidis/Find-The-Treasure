/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.util.ArrayList;
import game.Player;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Take implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();
        
        if (player.take(input)) {
            messages.add("The " + input + " is in you Inventory.");

        } else {
            messages.add("No such item");
        }

        return messages;
    }

}
