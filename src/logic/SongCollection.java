package logic;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class SongCollection {
    protected ArrayList<Song> songs = new ArrayList<>();
    protected String name;
    protected BufferedImage image = null;

    public SongCollection(String name) {
        this.name = name;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public abstract void addSong(Song song);

    public BufferedImage getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public void removeSong(Song song) {
        if (songs.contains(song)) {
            songs.remove(song);
            updateImage();
        } else
            JOptionPane.showMessageDialog(null, "The specified song doesn't exist");
    }

    protected void updateImage() {
        for (Song song : songs) {
            if (song.getImage() != null) {
                this.image = song.getImage();
                break;
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Song)) {
            return false;
        }
        if (name.equals(((SongCollection) obj).getName())) {
            return true;
        }
        return false;
    }
}
