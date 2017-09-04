/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import game.Player;
import java.util.ArrayList;
import things.Inanimate;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Eat implements VerbCommand {

    @Override
    public ArrayList<String> exec(String input, Player player) {
        ArrayList<String> messages = new ArrayList<>();

        Inanimate inanimate = player.findInanimate(input);
        if (player.eat(input)) {
            if (inanimate.isEatable()) {
                messages.add("That was awesome.");
                player.increasePower(inanimate.getEnergy());
            } else {
                messages.add("Not eatable");
            }

        } else {
            messages.add("No such item");
        }
        return messages;
    }
}
