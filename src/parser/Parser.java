/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Parser {

    /**
     * 
     * @param input is the user's input.
     * @return will return a verb and a noun.
     */
    public String[] modifyUserInput(String input) {
        int i = 0;
        boolean found = false;

        String[] parts = new String[2];
        CommandFactory factory = new CommandFactory();

        ArrayList<String> commands;

        String commandPart = null;
        String sectionPart = null;

        factory.add();
        commands = factory.getHashString();

        while (i < commands.size() && !found) {
            if (input.contains(commands.get(i))) {
                int pos = input.indexOf(commands.get(i));
                commandPart = input.substring(pos, commands.get(i).length()).trim();
                sectionPart = input.substring(commands.get(i).length()).trim();
                found = true;
            }
            i++;
        }

        parts[0] = commandPart;
        parts[1] = sectionPart;

        return parts;
    }
}
