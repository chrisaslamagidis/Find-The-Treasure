/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import things.Inanimate;
import java.util.ArrayList;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Player implements java.io.Serializable {

    private final String name;
    private final String description;
    private double health;
    private double power;
    private Room location;
    private ArrayList<Inanimate> inanimates;

    /**
     *
     * @param name
     * @param description
     * @param health
     * @param power
     * @param location
     */
    public Player(String name, String description, float health, float power, Room location) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.power = power;
        this.location = location;
        this.inanimates = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param description
     */
    public Player(String name, String description) {
        this(name, description, 0, 0, null);
    }

    /**
     *
     * @param name
     */
    public Player(String name) {
        this(name, null, 0, 0, null);
    }

    /**
     * Empty constructor.
     */
    public Player() {
        this(null, null, 0, 0, null);
    }

    /**
     *
     * @return used to return the name of the current player.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return used to return the description of the current player.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return used to return the health state of the current player.
     */
    public double getHealth() {
        return health;
    }

    /**
     *
     * @return used to return the power state of the current player.
     */
    public double getPower() {
        return power;
    }

    /**
     *
     * @return used to return the location of the current player.
     */
    public Room getLocation() {
        return location;
    }

    /**
     *
     * @return used to return a list of inanimates that are saved in the
     * inventory.
     */
    public ArrayList<Inanimate> getInanimates() {
        return inanimates;
    }

    /**
     *
     * @param inanimates used to set a list of inanimates to the inventory.
     */
    public void setInanimates(ArrayList<Inanimate> inanimates) {
        this.inanimates = inanimates;
    }

    /**
     *
     * @param health used to set the current state of health for the player.
     */
    public void setHealth(double health) {
        this.health = health;
    }

    /**
     *
     * @param power used to set the current state of power for the player.
     */
    public void setPower(double power) {
        this.power = power;
    }

    /**
     *
     * @param location used to set the current location of the player.
     */
    public void setLocation(Room location) {
        this.location = location;
    }

    /**
     *
     * @param inanimate used to add a inanimate to the inventory.
     */
    public void addInanimate(Inanimate inanimate) {
        inanimates.add(inanimate);
    }

    /**
     *
     * @param damage used to reduce the health of the player.
     */
    public void reduceHealth(double damage) {
        this.health = this.health - damage;
    }

    /**
     *
     * @param damage used to reduce the power of the player.
     */
    public void reducePower(double damage) {
        this.power = this.power - damage;
    }

    /**
     *
     * @param bonus used to add power to the player.
     */
    public void increasePower(double bonus) {
        this.power = this.power + bonus;
    }

    Inanimate removeInanimate(String thing) {
        Inanimate inanimate = findInanimate(thing);
        if (inanimate == null) {
            return null;
        }
        inanimates.remove(inanimate);
        return inanimate;
    }

    /**
     *
     * @param thing is used as an inanimate that is supposed to be eaten.
     * @return will return if thing has been eaten or not.
     */
    public boolean eat(String thing) {
        Inanimate inanimate = this.removeInanimate(thing);

        return inanimate != null;
    }

    /**
     *
     * @param thing is used as an inanimate that is supposed to be added to the
     * player's inventory.
     * @return will return if the thing was added or not.
     */
    public boolean take(String thing) {

        Inanimate inanimate = location.removeInanimate(thing);

        if (inanimate != null) {
            inanimates.add(inanimate);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @param thing used as an inanimate that is supposed to be removed from the
     * player's inventory.
     * @return will return if the thing was removed or not.
     */
    public boolean drop(String thing) {

        Inanimate inanimate = this.removeInanimate(thing);

        if (inanimate != null) {
            location.addInanimate(inanimate);
            return true;
        } else {
            return false;
        }
    }

    /**
     *
     * @return will return a list of inanimates that are included in the
     * player's inventory.
     */
    public ArrayList<String> viewInventory() {
        ArrayList<String> messages = new ArrayList<>();

        this.getInanimates().forEach((inanimate) -> {
            messages.add(inanimate.getDescription());
        });

        if (getInanimates().isEmpty()) {
            messages.add("Your inventory is empty.");
        }

        return messages;
    }

    /**
     *
     * @param thing used as an inanimate to be able to find it's self in the list
     * of inanimates.
     * @return will return the inanimate if found or null if not found.
     */
    public Inanimate findInanimate(String thing) {
        int i = 0;
        boolean found = false;
        Inanimate temporaryInanimate = null;

        while (i < this.getInanimates().size() && !found) {
            if (thing.equals(this.getInanimates().get(i).getName())) {
                found = true;
                temporaryInanimate = this.getInanimates().get(i);
            }
            i++;
        }
        return temporaryInanimate;

    }

}
