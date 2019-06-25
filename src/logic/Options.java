package logic;

import gui.South;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Options implements Runnable {
    JFileChooser fileChooser;
    File file;
    FileInputStream input;
    BufferedInputStream bufferedInput;
    AdvancedPlayer player;
    String address;
    int playedFrames;
    boolean isPaused;

    public Options(String address) {
//        System.out.println("We are in the constructor of Option...");
        this.address = address;
        isPaused = false;
        playedFrames = 0;
        fileChooser = new JFileChooser();
    }


    @Override
    public void run() {
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
        try {
            while (player.play(1)) {
                South.seekBar.setValue(playedFrames);
                playedFrames++;
                if (isPaused) {
                    synchronized (player) {
                        player.wait();
                    }
                }
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
        System.out.println(playedFrames);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPlayedFrames() {
        return playedFrames;
    }

    public void pauseMusic() {
        isPaused = true;
    }

    public void resumeMusic() {
        isPaused = false;
        synchronized (player) {
            player.notifyAll();
        }
    }

    public void seek(int frame) {
        synchronized (player) {
            boolean isFileOpened = false;
            try {
                player.close();
                input = new FileInputStream(new File(this.address));
                bufferedInput = new BufferedInputStream(input);
                player = new AdvancedPlayer(bufferedInput);
                player.play(frame, frame + 1);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "can't open file, please try again!");
                int result = fileChooser.showOpenDialog(null);
                if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION)
                    return;
                setAddress(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(this.address);
                isFileOpened = false;
            }catch (JavaLayerException e){
                JOptionPane.showMessageDialog(null, "FATAL ERROR");
            }
        }
    }
}
