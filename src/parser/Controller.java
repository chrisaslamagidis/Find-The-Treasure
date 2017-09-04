/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import commands.VerbCommand;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Controller {

    /**
     *
     * @param commandPart is used as a command that is found by the parser.
     * @return will return a VerbCommand.
     */
    public VerbCommand findCommand(String commandPart) {
        CommandFactory factory = new CommandFactory();

        factory.add();//Create HashMap

        if (commandPart != null) {
            VerbCommand c = factory.getInstance(commandPart);
            return c;
        } else {
            return null;
        }
    }

}
