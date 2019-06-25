package logic;

import javax.swing.*;

public class Playlist extends SongCollection {
    public Playlist(String playlistName) {
        super(playlistName);
    }

    @Override
    public void addSong(Song song) {
        if (song != null && song.getMp3File() != null) {
            songs.add(song);
            updateImage();
        } else
            JOptionPane.showMessageDialog(null, "Error occurred while adding");
    }

    public void addSongs(SongCollection songCollection) {
        if (songCollection != null)
            for (Song song : songCollection.getSongs())
                addSong(song);
    }
}
