/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package things;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Thing implements java.io.Serializable {

    private final String name;
    private final String description;
    private boolean available;

    /**
     *
     * @param name
     * @param description
     * @param available
     */
    public Thing(String name, String description, boolean available) {
        this.name = name;
        this.description = description;
        this.available = available;
    }

    /**
     *
     * @return will return the name of the thing.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return will return the description of the thing.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return will return if the thing is available or not.
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     *
     * @param available is used to set if a thing will be available or not.
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

}
