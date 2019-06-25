package logic;

import javax.swing.*;

public class Album extends SongCollection {
    private String artistName;

    public Album(String albumName, String artistName) {
        super(albumName);
        this.artistName = artistName;
    }

    @Override
    public void addSong(Song song) {
        if (song != null && song.getMp3File() != null && song.getAlbumName().equals(name)) {
            songs.add(song);
            updateImage();
        } else
            JOptionPane.showMessageDialog(null, "Error occurred while adding");
    }
}
