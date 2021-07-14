/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Java program to play an Audio
// file using Clip Object

import javax.sound.sampled.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author James De Leon
 * 
 */
public class Music extends javax.swing.JFrame  {

    // to store current position
    Long cf;
    static Clip clip;
    static Music musicPlayer;
    String status = "default";

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
        InputStream bInputStream = new BufferedInputStream(is);
        audioInputStream = AudioSystem.getAudioInputStream(bInputStream);

        // create clip reference
        clip = AudioSystem.getClip();

        // open audioInputStream to the clip
        clip.open(audioInputStream);

        clip.loop(Clip.LOOP_CONTINUOUSLY);

        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-5);

    }

    // Work as the user enters his choice

    // Method to play the audio
    public void play() {
        //start the clip
        clip.start();
        status = "playing";
    }

    // Method to pause the audio
    public void pause() {

        this.cf = Music.clip.getMicrosecondPosition();
        clip.stop();
        status = "paused";
    }

    public void changeVolume(int volume){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue( (float) volume);
    }

    public String getStatus(){
        return status;
    }






}
