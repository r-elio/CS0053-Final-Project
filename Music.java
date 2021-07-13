/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Java program to play an Audio
// file using Clip Object

import javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class Music extends javax.swing.JFrame  {

    // to store current position
    Long cf;
    static Clip clip;
    static Music musicPlayer;
    String status;

    static {
        try {
            musicPlayer = new Music();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    AudioInputStream audioInputStream;
    InputStream is = getClass().getClassLoader().getResourceAsStream("bgm.wav");

    public static Music getInstance(){
        return musicPlayer;
    }

    // constructor to initialize streams and clip
    public Music()
            throws UnsupportedAudioFileException,
            IOException, LineUnavailableException {
        // create AudioInputStream object
        audioInputStream = AudioSystem.getAudioInputStream(is);

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    // Work as the user enters his choice
    

    // Method to play the audio
    public void play() {
        //start the clip
        clip.start();
        status = "play";
    }

    // Method to pause the audio
    public void pause() {
        if (status.equals("paused")) {
            System.out.println("audio is already paused");
            return;
        }
        this.cf = Music.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }






}
