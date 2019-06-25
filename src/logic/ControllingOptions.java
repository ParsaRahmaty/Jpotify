package logic;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.io.*;

public class ControllingOptions extends Thread {
    JFileChooser fileChooser;
    File file;
    FileInputStream input;
    BufferedInputStream bufferedInput;
    AdvancedPlayer player;
    String address;
    int playedFrames;
    boolean isPaused;

    public ControllingOptions(String address) {
        super(new Runnable() {
            @Override
            public void run() {

            }
        });
        isPaused = false;
        playedFrames = 0;
        this.address = address;
        fileChooser = new JFileChooser();
        boolean isFileOpened = false;
        while (!isFileOpened) {
            try {
                input = new FileInputStream(new File(this.address));
                isFileOpened = true;
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "can't open file, please try again!");
                int result = fileChooser.showOpenDialog(null);
                if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION)
                    return;
                setAddress(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(this.address);
                isFileOpened = false;
            }
        }
        bufferedInput = new BufferedInputStream(input);
        try {
            player = new AdvancedPlayer(bufferedInput);
        } catch (JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "FATAL ERROR");
        }
    }



    public void playMusic() {
        try {
            while (player.play(1)){
                playedFrames++;
            }
        } catch (JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "FATAL ERROR");
        }
    }



    public void pauseMusic(){
        try {
            player.wait();
            isPaused = true;
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Can't pause");
        }
    }

    public void resumeMusic(){
        isPaused = false;
        synchronized (player) {
            player.notifyAll();
        }
    }



    public void seek(){

    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPlayedFrames() {
        return playedFrames;
    }
}
