/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import sun.audio.*;
/**
 *
 * @author Mark Egana
 */
public class Music {
    
    public void playMusic(){
 
       //make a new AudioPlayer.
              AudioPlayer MGP = AudioPlayer.player;
              AudioStream BGM;
              AudioData MD;
              ContinuousAudioDataStream myLoop = null;
  	//use a try block in case the file doesn't exist.
              try {
              String filelocation  ="C:\\Users\\Gela Egana\\Documents\\NetBeansProjects\\CS0053-Final-Project\\JavaFXApplication1\\bg1.wav";
              InputStream test= new FileInputStream(filelocation);
              BGM = new AudioStream(test);
              MGP.start(myLoop);
              AudioPlayer.player.start(BGM);
              
              }
              catch(Exception error) {
                  JOptionPane.showMessageDialog(null, "Invalid file!");
                  error.printStackTrace();
              }

             
             
    }
     
}   
