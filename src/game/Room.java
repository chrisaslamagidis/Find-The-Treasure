/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.ArrayList;
import things.Container;
import things.Inanimate;
import things.Inspirit;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Room implements java.io.Serializable {

    private final String name;
    private final String description;
    private boolean locked;
    private final ArrayList<Container> containers;
    private final ArrayList<Inanimate> inanimates;
    private final ArrayList<Inspirit> inspirits;
    private final ArrayList<Room> destinationRooms;

    /**
     *
     * @param name
     * @param description
     * @param islocked
     */
    public Room(String name, String description, boolean islocked) {
        this.name = name;
        this.description = description;
        this.locked = islocked;
        this.containers = new ArrayList<>();
        this.inanimates = new ArrayList<>();
        this.inspirits = new ArrayList<>();
        this.destinationRooms = new ArrayList<>();

    }

    /**
     *
     * @param name
     * @param description
     */
    public Room(String name, String description) {
        this(name, description, false);
    }

    /**
     *
     * @param name
     */
    public Room(String name) {
        this(name, null, false);
    }

    /**
     * Empty constructor.
     */
    public Room() {
        this(null, null, false);
    }

    /**
     *
     * @return returns the name of the room.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return returns the description of the room.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return returns if the room is locked or not.
     */
    public boolean isLocked() {
        return locked;
    }

    /**
     *
     * @return returns a list of containers inside the room.
     */
    public ArrayList<Container> getContainers() {
        return containers;
    }

    /**
     *
     * @return returns a list of inanimates inside the room.
     */
    public ArrayList<Inanimate> getInanimates() {
        return inanimates;
    }

    /**
     *
     * @return returns a list of inspirits inside the room.
     */
    public ArrayList<Inspirit> getInspirits() {
        return inspirits;
    }

    /**
     *
     * @return returns a list of destination rooms from the current room.
     */
    public ArrayList<Room> getDestinationRooms() {
        return destinationRooms;
    }

    /**
     *
     * @param locked used for locking or unlocking a room.
     */
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    /**
     *
     * @param inanimate used to add an inanimate to the room.
     */
    public void addInanimate(Inanimate inanimate) {
        inanimates.add(inanimate);
    }

    /**
     *
     * @param inspirit used to add an inspirit to the room.
     */
    public void addInspirit(Inspirit inspirit) {
        inspirits.add(inspirit);
    }

    /**
     *
     * @param container used to add a container to the room.
     */
    public void addContainer(Container container) {
        containers.add(container);
    }

    /**
     *
     * @param room used to add a destination room from the current room.
     */
    public void addDestinationRoom(Room room) {
        destinationRooms.add(room);
    }

    /**
     *
     * @param inanimate used to remove an inanimate from the room.
     */
    public void removeInanimate(Inanimate inanimate) {
        inanimates.remove(inanimate);
    }

    /**
     *
     * @param inspirit used to remove an inspirit from the room.
     */
    public void removeInspirit(Inspirit inspirit) {
        inspirits.remove(inspirit);
    }

    /**
     *
     * @param container used to remove a container from the room.
     */
    public void removeContainer(Container container) {
        containers.remove(container);
    }

    /**
     *
     * @param room used to remove a destination room from this room.
     */
    public void removeDestinationRoom(Room room) {
        destinationRooms.remove(room);
    }

    /**
     *
     * @param thing used as a inanimate to be removed.
     */
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
     * @param destination used as a room to be checked if it's the next room
     * available.
     * @return will return a room if found or null if was not found.
     */
    public Room findMatch(String destination) {
        int i = 0;
        boolean found = false;
        Room temporaryRoom = null;

        while (i < this.getDestinationRooms().size() && !found) {
            if (destination.equals(getDestinationRooms().get(i).getName())) {
                temporaryRoom = getDestinationRooms().get(i);
                found = true;
            }
            i++;
        }

        return temporaryRoom;
    }

    /**
     *
     * @param thing used as an inanimate to be able to find itself in the list
     * of inanimates.
     * @return will return the ininimate if found or null if not found.
     */
    public Inanimate findInanimate(String thing) {
        int i = 0;
        boolean found = false;
        Inanimate temporaryInanimate = null;

        while (i < this.getInanimates().size() && !found) {
            if (thing.equals(this.getInanimates().get(i).getName())) {
                found = true;
                if (getInanimates().get(i).isUseable()) {
                    temporaryInanimate = this.getInanimates().get(i);
                }
            }
            i++;
        }
        return temporaryInanimate;

    }

    /**
     *
     * @return will return a list of inanimates, inspirits and containers inside
     * the current room.
     */
    public ArrayList<String> lookAround() {
        ArrayList<String> messages = new ArrayList<>();

        this.getInanimates().forEach((inanimate) -> {
            messages.add(inanimate.getName());
        });
        this.getInspirits().forEach((inspirit) -> {
            messages.add(inspirit.getName());
        });
        this.getContainers().forEach((container) -> {
            messages.add(container.getName());
        });

        if (getInanimates().isEmpty() && getContainers().isEmpty() && getInspirits().isEmpty()) {
            messages.add("You cannot see something in this room.");
        }

        return messages;
    }

    /**
     *
     * @param thing is used as a container to able to find itself in the list
     * of containers.
     * @return will return the container if found or null if not found.
     */
    public Container findContainer(String thing) {
        int i = 0;
        boolean found = false;
        Container temporaryContainer = null;

        while (i < this.getContainers().size() && !found) {
            if (thing.equals(this.getContainers().get(i).getName())) {
                found = true;
                temporaryContainer = this.getContainers().get(i);
            }
            i++;
        }
        return temporaryContainer;

    }

    /**
     *
     * @param inanimates is used as a list to add inanimates from a container to
     * a room.
     */
    public void addContainersInanimates(ArrayList<Inanimate> inanimates) {
        this.inanimates.addAll(inanimates);
    }

    /**
     *
     * @param inanimates is used as a list to remove inanimates from a room to a
     * container.
     */
    public void removeContainersInanimates(ArrayList<Inanimate> inanimates) {
        this.inanimates.removeAll(inanimates);
    }
}
