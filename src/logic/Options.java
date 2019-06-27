package logic;

import gui.MusicTime;
import gui.South;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Options implements Runnable {
    private JFileChooser fileChooser;
    private FileInputStream input;
    private BufferedInputStream bufferedInput;
    private AdvancedPlayer player;
    private String address;
    private int playedFrames;
    private boolean isPaused;
    private JProgressBar seekBar;

    public Options(String address, JProgressBar seekBar) {
        this.seekBar = seekBar;
        this.address = address;
        isPaused = false;
        playedFrames = 1;
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
                long coefficient = Manager.getNowPlayingSong().getMp3File().getFrameCount() / Manager.getNowPlayingSong().getMp3File().getLengthInSeconds();
                Manager.getMainFrame().getSouth().getTimeElapsed().setValue(playedFrames / (int) coefficient);
                South.elapsed.setText(Manager.getMainFrame().getSouth().getTimeElapsed().toString() + " ");
//                South.elapsed.setText(Integer.toString(playedFrames / (int)coefficient));//new
                if (playedFrames / (int) coefficient >= Manager.getNowPlayingSong().getMp3File().getLengthInSeconds()) {
                    Manager.getMainFrame().getSouth().getTimeElapsed().setValue((int) Manager.getNowPlayingSong().getMp3File().getLengthInSeconds());
                    South.elapsed.setText(Manager.getMainFrame().getSouth().getTimeElapsed().toString() + " ");
                }
//                South.elapsed.setText(South.timeElapsed.toString() + " ");

                this.seekBar.setValue(playedFrames);
                playedFrames++;
                if (isPaused) {
                    synchronized (player) {
                        player.wait();
                    }
                }
            }
            playedFrames++;
            seekBar.setValue(playedFrames);
            if (seekBar.getValue() == seekBar.getMaximum())
                isPaused = true;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
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
                if (isPaused) {
                    resumeMusic();
//                player.close();
                    input = new FileInputStream(new File(this.address));
                    bufferedInput = new BufferedInputStream(input);
                    player = new AdvancedPlayer(bufferedInput);
                    playedFrames = frame;
                    this.seekBar.setValue(playedFrames);
                    player.play(frame, frame + 1);
                    pauseMusic();
                }
                else {
                    input = new FileInputStream(new File(this.address));
                    bufferedInput = new BufferedInputStream(input);
                    player = new AdvancedPlayer(bufferedInput);
                    playedFrames = frame;
                    this.seekBar.setValue(playedFrames);
                    player.play(frame, frame + 1);
                }
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "can't open file, please try again!");
                int result = fileChooser.showOpenDialog(null);
                if (result == JOptionPane.CLOSED_OPTION || result == JOptionPane.CANCEL_OPTION)
                    return;
                setAddress(fileChooser.getSelectedFile().getAbsolutePath());
                isFileOpened = false;
            } catch (JavaLayerException e) {
                JOptionPane.showMessageDialog(null, "FATAL ERROR");
            }
        }
    }


    public boolean isPaused() {
        return isPaused;
    }
}