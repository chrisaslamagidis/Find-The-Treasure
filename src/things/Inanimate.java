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
public class Inanimate extends Thing implements java.io.Serializable {

    private boolean useable;
    private boolean eatable;
    private final boolean harmful;
    private final boolean weapon;
    private final boolean readable;
    private final double energy;

    /**
     *
     * @param useable
     * @param eatable
     * @param harmful
     * @param weapon
     * @param readable
     * @param energy
     * @param name
     * @param description
     * @param available
     */
    public Inanimate(boolean useable, boolean eatable, boolean harmful, boolean weapon, boolean readable, double energy, String name, String description, boolean available) {
        super(name, description, available);
        this.useable = useable;
        this.eatable = eatable;
        this.harmful = harmful;
        this.weapon = weapon;
        this.readable = readable;
        this.energy = energy;
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param useable
     */
    public Inanimate(String name, String description, boolean available, boolean useable) {
        this(useable, false, false, false, false, 0, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param useable
     * @param readable
     */
    public Inanimate(String name, String description, boolean available, boolean useable, boolean readable) {
        this(useable, false, false, false, readable, 0, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param useable
     * @param eatable
     * @param energy
     */
    public Inanimate(String name, String description, boolean available, boolean useable, boolean eatable, double energy) {
        this(useable, eatable, false, false, false, energy, name, description, available);
    }

    /**
     *
     * @param name
     * @param description
     * @param available
     * @param useable
     * @param harmful
     * @param weapon
     */
    public Inanimate(String name, String description, boolean available, boolean useable, boolean harmful, boolean weapon) {
        this(useable, false, harmful, weapon, false, 0, name, description, available);
    }

    /**
     *
     * @return will return if the inanimate is useable or not.
     */
    public boolean isUseable() {
        return useable;
    }

    /**
     *
     * @return will return if the inanimate is eatable or not.
     */
    public boolean isEatable() {
        return eatable;
    }

    /**
     *
     * @return will return if the inanimate is harmful or not.
     */
    public boolean isHarmful() {
        return harmful;
    }

    /**
     *
     * @return will return if the inanimate is a weapon or not.
     */
    public boolean isWeapon() {
        return weapon;
    }

    /**
     *
     * @return will return if the inanimate is readable or not.
     */
    public boolean isReadable() {
        return readable;
    }

    /**
     *
     * @return will return the energy of an inanimate.
     */
    public double getEnergy() {
        return energy;
    }

    /**
     *
     * @param useable is used to set if the inanimate will be useable or not.
     */
    public void setUseable(boolean useable) {
        this.useable = useable;
    }

    /**
     *
     * @param eatable is used to set if the inanimate will be eatable or not.
     */
    public void setEatable(boolean eatable) {
        this.eatable = eatable;
    }

}
