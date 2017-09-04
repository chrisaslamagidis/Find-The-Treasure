/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package things;

import java.util.ArrayList;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Container extends Thing {

    private boolean open;
    private boolean openable;
    private boolean empty;
    private final int weight;
    private final boolean relax;
    private final ArrayList<Inanimate> inanimates;

    /**
     *
     * @param open
     * @param empty
     * @param weight
     * @param relax
     * @param name
     * @param description
     * @param available
     */
    public Container(boolean open, boolean empty, int weight, boolean relax, String name, String description, boolean available) {
        super(name, description, available);
        this.open = open;
        this.empty = empty;
        this.weight = weight;
        this.relax = relax;
        this.openable = false;
        this.inanimates = new ArrayList<>();
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param open
     * @param empty
     * @param weight
     * @param openable
     */
    public Container(String name, String description, boolean available, boolean open, boolean empty, int weight, boolean openable) {
        this(open, empty, weight, false, name, description, available);
        this.openable = openable;
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param open
     * @param empty
     */
    public Container(String name, String description, boolean available, boolean open, boolean empty) {
        this(open, empty, 0, false, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param empty
     * @param weight
     * @param relax
     */
    public Container(String name, String description, boolean available, boolean empty, int weight, boolean relax) {
        this(false, empty, weight, relax, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param empty
     * @param weight
     */
    public Container(String name, String description, boolean available, boolean empty, int weight) {
        this(false, empty, weight, false, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param empty
     */
    public Container(String name, String description, boolean available, boolean empty) {
        this(false, empty, 0, false, name, description, available);
    }

    /**
     *
     * @return will return if the container is open.
     */
    public boolean isOpen() {
        return open;
    }

    /**
     *
     * @return will return if the container is empty.
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     *
     * @return will return the weight of a container.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * TODO: Find a better name of the variable 'Relax'
     *
     * @return
     */
    public boolean isRelax() {
        return relax;
    }

    /**
     *
     * @return will return if the container is open.
     */
    public boolean isOpenable() {
        return openable;
    }

    /**
     *
     * @return will return a list of inanimates inside the container.
     */
    public ArrayList<Inanimate> getInanimates() {
        return inanimates;
    }

    /**
     *
     * @param open is used to open or close a container.
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     *
     * @param empty is used to set a container as empty or not.
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    /**
     *
     * @param inanimate is used to add an inanimate to a container.
     */
    public void addInanimate(Inanimate inanimate) {
        inanimates.add(inanimate);
    }

    /**
     *
     * @param inanimate is used to remove an inanimate from a container.
     */
    public void removeInanimate(Inanimate inanimate) {
        inanimates.remove(inanimate);
    }

}
