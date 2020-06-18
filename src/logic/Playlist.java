package logic;

import javax.swing.*;

public class Playlist extends SongCollection implements Addable{
    public Playlist(String playlistName) {
        super(playlistName);
    }

    @Override
    public void addSong(Song song) {
        if (song != null && song.getMp3File() != null) {
            if (!songs.contains(song))
                songs.add(song);
            else
                JOptionPane.showMessageDialog(null, "Song already exists in the playlist");
            updateImage();
        } else
            JOptionPane.showMessageDialog(null, "Error occurred while adding");
    }

    public void addSongs(SongCollection songCollection) {
        if (songCollection != null) {
            for (Song song : songCollection.getSongs())
                addSongWithoutMessages(song);
            JOptionPane.showMessageDialog(null, "All new songs was added successfully!");
        }
    }

    private void addSongWithoutMessages(Song song) {
        if (song != null && song.getMp3File() != null) {
            if (!songs.contains(song))
                songs.add(song);
            updateImage();
        }
    }

    public boolean shiftSongBack(Song song) {
        if (songs.contains(song)) {
            if (songs.indexOf(song) > 0) {
                songs.add(songs.indexOf(song) - 1, song);
                songs.remove(songs.lastIndexOf(song));
                return true;
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "The song no longer exist in the playlist.\nOperation unsuccessful");
            return false;
        }
    }

    public boolean shiftSongFront(Song song) {
        if (songs.contains(song)) {
            if (songs.indexOf(song) + 1 < songs.size()) {
                songs.add(songs.indexOf(song) + 2, song);
                songs.remove(songs.indexOf(song));
                return true;
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "The song no longer exist in the playlist.\nOperation unsuccessful");
            return false;
        }
    }
}
