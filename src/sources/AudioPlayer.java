/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sources;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Xristos Aslamagtzidis
 */
public class AudioPlayer {

    /**
     *
     * @param sound
     */
    public void playsound(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            //Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("error");

        }

    }
    
    /**
     *
     * @param sound
     */
    public void playsoundWithThreadSleep(File sound) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(sound));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
           
        } catch (IOException | InterruptedException | LineUnavailableException | UnsupportedAudioFileException e) {
            System.out.println("error");

        }

    }

}
