/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import game.Room;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import resources.ResourceManager;
import things.Container;
import things.Inanimate;
import things.Inspirit;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class Scenario {

    ResourceManager file = new ResourceManager();
    ArrayList<Room> rooms = new ArrayList<>();

    /**
     * This method will load the rooms from a text file in to a list of rooms.
     *
     * @return will return a list of rooms.
     */
    public ArrayList<Room> fetchRooms() {
        Path path = file.openFile("src\\sources", "rooms.txt");

        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String description = parts[1].trim();
                boolean locked = parts[2].trim().equals("locked");
                rooms.add(new Room(name, description, locked));
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        return rooms;
    }

    /**
     * This method will load the containers from a text file and place them in
     * to rooms.
     */
    public void placeContainers() {
        Path path = file.openFile("src\\sources", "containers.txt");
        int i;
        boolean found;
        Room currentRoom = new Room();

        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line;

            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                String description = parts[1].trim();
                int weight = Integer.parseInt(parts[5].trim());
                boolean available = parts[2].trim().equals("available");
                boolean open = parts[3].trim().equals("open");
                boolean empty = parts[4].trim().equals("empty");
                boolean openable = parts[6].trim().equals("openable");

                i = 0;
                found = false;

                while (i < this.rooms.size() && !found) {
                    if (parts[7].trim().equals(this.rooms.get(i).getName())) {
                        currentRoom = this.rooms.get(i);
                        found = true;
                    }
                    i++;
                }
                currentRoom.addContainer((new Container(name, description, available, open, empty, weight, openable)));
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     * This method will load the Inanimates from a text file and place them in
     * to rooms.
     */
    public void placeInanimates() {
        Path path = file.openFile("src\\sources", "inanimates.txt");
        int i;
        int j;
        boolean found;
        Room currentRoom;
        Container currentContainer;

        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line;

            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] parts = line.split(",");
                boolean useable = parts[0].trim().equals("useable");
                boolean eatable = parts[1].trim().equals("eatable");
                boolean harmful = parts[2].trim().equals("harmful");
                boolean weapon = parts[3].trim().equals("weapon");
                boolean readable = parts[4].trim().equals("readable");
                boolean available = parts[8].trim().equals("available");
                String name = parts[6].trim();
                String description = parts[7].trim();
                double energy = Double.parseDouble(parts[5].trim());

                i = 0;
                found = false;

                while (i < this.rooms.size() && !found) {
                    if (parts[9].trim().equals(this.rooms.get(i).getName())) {
                        currentRoom = this.rooms.get(i);
                        currentRoom.addInanimate(new Inanimate(useable, eatable, harmful, weapon, readable, energy, name, description, available));
                        found = true;
                    }
                    i++;
                }

                i = 0;

                while (i < this.rooms.size() && !found) {
                    j = 0;
                    while (j < this.rooms.get(i).getContainers().size()) {
                        if (parts[9].trim().equals(this.rooms.get(i).getContainers().get(j).getName().trim())) {
                            currentContainer = this.rooms.get(i).getContainers().get(j);
                            currentContainer.addInanimate(new Inanimate(useable, eatable, harmful, weapon, readable, energy, name, description, available));
                            found = true;
                        }
                        j++;
                    }
                    i++;
                }
            }

        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     * This method will load the Inspirits from a text file and place them in to
     * rooms.
     */
    public void placeInspirits() {
        Path path = file.openFile("src\\sources", "inspirits.txt");
        int i;
        boolean found;
        Room currentRoom = new Room();

        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line;

            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] parts = line.split(",");

                String sex = parts[0].trim();
                String language = parts[1].trim();
                String hairColor = parts[2].trim();
                String age = parts[3].trim();
                String thickness = parts[4].trim();
                String height = parts[5].trim();
                String name = parts[6].trim();
                String description = parts[7].trim();
                boolean available = parts[8].trim().equals("available");

                i = 0;
                found = false;

                while (i < this.rooms.size() && !found) {
                    if (parts[9].trim().equals(this.rooms.get(i).getName())) {
                        currentRoom = this.rooms.get(i);
                        found = true;
                    }
                    i++;
                }

                currentRoom.addInspirit(new Inspirit(sex, language, hairColor, age, thickness, height, name, description, available));
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     * This method will load the destination rooms from a text file and create a
     * map of available rooms.
     */
    public void createMap() {
        Path path = file.openFile("src\\sources", "map.txt");
        int i;
        boolean found;
        Room currentRoom = new Room();

        try (InputStream in = Files.newInputStream(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            String line;
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                String[] parts = line.split(",");
                i = 0;
                found = false;

                while (i < this.rooms.size() && !found) {
                    if (parts[0].trim().equals(this.rooms.get(i).getName())) {
                        currentRoom = this.rooms.get(i);
                        found = true;
                    }
                    i++;
                }

                for (int j = 1; j < parts.length; j++) {
                    i = 0;
                    found = false;
                    while (i < this.rooms.size() && !found) {
                        if (parts[j].trim().equals(this.rooms.get(i).getName())) {
                            currentRoom.addDestinationRoom(this.rooms.get(i));
                            found = true;
                        }
                        i++;
                    }
                }

            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

    /**
     *
     * @return will return a list of rooms.
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
