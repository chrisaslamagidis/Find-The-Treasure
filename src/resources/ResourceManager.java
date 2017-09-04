/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Xristos Aslamatzidis
 */
public class ResourceManager {

    /**
     *
     * @param data
     * @param fileName
     * @throws Exception
     */
    public static void save(Serializable data, String fileName) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)))) {
            oos.writeObject(data);
        }
    }

    /**
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static Object load(String fileName) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            return ois.readObject();
        }

    }

    /**
     *
     * @param folder
     * @param fileName
     * @return
     */
    public Path openFile(String folder, String fileName) {
        return FileSystems.getDefault().getPath(folder, fileName);
    }

    /**
     * TODO: create a algorithm that will close a file.
     *
     * @return
     */
    public boolean closeFile() {
        return false;
    }
}
