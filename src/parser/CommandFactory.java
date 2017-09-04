/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import commands.Close;
import commands.Drop;
import commands.Eat;
import commands.VerbCommand;
import commands.GoTo;
import commands.LookAround;
import commands.LookIn;
import commands.Open;
import commands.Take;
import commands.ViewInventory;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class CommandFactory {

    HashMap<String, VerbCommand> hashmap = new HashMap<>();

    /**
     *
     * @return will return a HashMap of String's that match a command.
     */
    public HashMap<String, VerbCommand> getHashmap() {
        return hashmap;
    }

    /**
     *
     * @return will return the keySet of the HashMap.
     */
    public ArrayList<String> getHashString() {
        ArrayList<String> commands = new ArrayList<>();

        hashmap.keySet().forEach((key) -> {
            commands.add(key);
        });

        return commands;

    }

    /**
     * Creates the commands that are going to be used in the game.
     *
     * TODO: Reflection idea.
     */
    public void add() {
        /*--------- Initializing Objects ---------*/
        GoTo goTo = new GoTo();
        Take take = new Take();
        Drop drop = new Drop();
        Eat eat = new Eat();
        LookIn lookIn = new LookIn();
        Open open = new Open();
        Close close = new Close();
        LookAround lookAround = new LookAround();
        ViewInventory viewInventory = new ViewInventory();

        /*--------- Adding values to hashmap ---------*/
        hashmap.put("go to", goTo);
        hashmap.put("go to the", goTo);
        hashmap.put("move to", goTo);
        hashmap.put("take", take);
        hashmap.put("drop", drop);
        hashmap.put("view inventory", viewInventory);
        hashmap.put("look around", lookAround);
        hashmap.put("eat", eat);
        hashmap.put("look in", lookIn);
        hashmap.put("open", open);
        hashmap.put("close", close);

    }

    /**
     *
     * @param command is used for the command part that is fetched by the parser
     * from the user's input.
     * @return will return a VerbCommand that is attached to the hashmap for the
     * current command.
     */
    public VerbCommand getInstance(String command) {
        return hashmap.get(command);
    }

}
