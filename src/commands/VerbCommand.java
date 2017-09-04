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
public interface VerbCommand {
    
    /**
     * Based on the command factory pattern.
     *
     * @param input is the noun from the user's input.
     * @param player is the current player that is set for the current game.
     * @return will return a list of messages from the execution.
     */
    public ArrayList<String> exec(String input, Player player);
}
