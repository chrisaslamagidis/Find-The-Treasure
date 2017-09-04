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
public class Inspirit extends Thing implements java.io.Serializable {

    private final String sex;
    private final String language;
    private final String hairColor;
    private final String age;
    private final String thickness;
    private final String height;

    /**
     *
     * @param sex
     * @param language
     * @param hairColor
     * @param age
     * @param thickness
     * @param height
     * @param name
     * @param description
     * @param available
     */
    public Inspirit(String sex, String language, String hairColor, String age, String thickness,
            String height, String name, String description, boolean available) {
        super(name, description, available);
        this.sex = sex;
        this.language = language;
        this.hairColor = hairColor;
        this.age = age;
        this.thickness = thickness;
        this.height = height;
    }

    /**
     *
     * @return will return the sex of the inspirit.
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @return will return the speaking language of the inspirit.
     */
    public String getLanguage() {
        return language;
    }

    /**
     *
     * @return will return the hair color of the inspirit.
     */
    public String getHairColor() {
        return hairColor;
    }

    /**
     *
     * @return will return the age of the inspirit.
     */
    public String getAge() {
        return age;
    }

    /**
     *
     * @return will return the hair thickness of the inspirit.
     */
    public String getThickness() {
        return thickness;
    }

    /**
     *
     * @return will return the hight of the inspirit.
     */
    public String getHeight() {
        return height;
    }

}
