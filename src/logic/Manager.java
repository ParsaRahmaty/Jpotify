package logic;

import gui.MainFrame;

import javax.swing.*;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Random;

public class Manager {
    public static MainFrame mainFrame;
    public static ArrayList<Song> songs = new ArrayList<>();
    public static ArrayList<Album> albums = new ArrayList<>();
    public static ArrayList<Playlist> playlists = new ArrayList<>();
    public static ArrayList<Library> libraries = new ArrayList<>();
    public static ArrayList<Song> nowPlaying = new ArrayList<>();
    public static Song nowPlayingSong;
    public static ArrayList<Song> shufflingSongs;

    public static void setMainFrame(MainFrame mainFrame) {
        Manager.mainFrame = mainFrame;
    }

    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }

    public static ArrayList<Album> getAlbums() {
        return albums;
    }

    public static ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public static ArrayList<Library> getLibraries() {
        return libraries;
    }

    public static ArrayList<Song> getNowPlaying() {
        return nowPlaying;
    }

    public static void makeAndAddSong(String filePath) {
        Song newSong = new Song(filePath);
        if (newSong.getMp3File() != null && !songs.contains(newSong)) {
            songs.add(newSong);
            boolean doesAlbumExist = false;
            for (Album album : albums) {
                if (album.getName().equals(newSong.getAlbumName())) {
                    album.addSong(newSong);
                    doesAlbumExist = true;
                    break;
                }
            }
            if (!doesAlbumExist) {
                Album album = new Album(newSong.getAlbumName(), newSong.getArtistName());
                album.addSong(newSong);
            }
        }
    }

    public static void removeSong(Song song) {
        if (songs.contains(song)) {
            songs.remove(song);
            for (Album album : albums) {
                if (album.getSongs().contains(song)) {
                    album.removeSong(song);
                }
                if (album.getSongs().size() == 0) {
                    Manager.removeAlbum(album);
                }
            }
            for (Playlist playlist : playlists) {
                if (playlist.getSongs().contains(song)) {
                    playlist.removeSong(song);
                }
            }
        } else
            JOptionPane.showMessageDialog(null, "The song couldn't be removed");
    }

    public static void removeLibrarySongs(Library library) {
        if (library.isDirectory()) {
            for (Song song : songs) {
                if (song.getFilePath().contains(library.getPath()) && song.getFilePath().split("\\\\").length == library.getPath().split("\\\\").length + 1)
                    removeSong(song);
            }
        } else {
            for (Song song : songs) {
                if (song.getFilePath().equals(library.getPath()))
                    removeSong(song);
            }
        }
    }

    private static void removeAlbum(Album album) {
        if (albums.contains(album)) {
            albums.remove(album);
        }
    }

    private static void addAlbum(Album album) {
        if (!albums.contains(album)) {
            albums.add(album);
        }
    }

    public static void addPlaylist(Playlist playlist) {
        if (!playlists.contains(playlist)) {
            playlists.add(playlist);
        } else {
            JOptionPane.showMessageDialog(null, "You can't have two playlists with the same name\nPlease choose a different name");
        }
    }

    public static void removePlaylist(Playlist playlist) {
        if (playlists.contains(playlist)) {
            playlists.remove(playlist);
        }
    }

    public static void addLibrary(Library library) {
        if (!libraries.contains(library)) {
            libraries.add(library);
            importLibrarySongs(library);
        } else {
            JOptionPane.showMessageDialog(null, "The library was already added before");
        }
    }

    public static void removeLibrary(Library library) {
        if (libraries.contains(library)) {
            libraries.remove(library);
        }
    }

    public static void importLibrarySongs(Library library) {
        File file = new File(library.getPath());
        if (file.exists()) {
            if (library.isDirectory()) {
                String[] list = file.list(new FilenameFilter() {
                    @Override
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".mp3");
                    }
                });
                for (String mp3Name : list) {
                    if (!Manager.getSongs().contains(new Song(library.getPath() + "\\" + mp3Name)))
                        makeAndAddSong(library.getPath() + "\\" + mp3Name);
                }
            } else {
                makeAndAddSong(library.getPath());
            }
        } else {
            removeLibrary(library);
        }
    }

    public static void setNowPlaying(ArrayList<Song> nowPlaying) {
        Manager.nowPlaying = nowPlaying;
    }

    public static void setNowPlayingSong(Song nowPlayingSong) {
        if (nowPlayingSong != null)
            Manager.nowPlayingSong = nowPlayingSong;
    }

    public static Song getNowPlayingSong() {
        return nowPlayingSong;
    }

    public static void calculateNextSong(boolean isRepeat, boolean isShuffle) {
        shufflingSongs = null;
        if (isShuffle) {
            if (isRepeat){
                int randomShuffle = randomGenerator(nowPlaying.size());
                nowPlayingSong = nowPlaying.get(randomShuffle);
            }
            else {
                shufflingSongs = new ArrayList<>();//new
                shufflingSongs = nowPlaying;
                int randomShuffle = randomGenerator(shufflingSongs.size());
                nowPlayingSong = shufflingSongs.get(randomShuffle);
                shufflingSongs.remove(randomShuffle);
                if (shufflingSongs.size() == 0)
                    nowPlayingSong = null;
            }
        } else {
            if (!isRepeat) {
                nowPlayingSong = nowPlaying.get(nowPlaying.indexOf(nowPlayingSong) + 1);
            }
        }
        //raste kare toe mohammadreza ;)
        //void gozashtam chon faghat meghdaresho tooye nowPlayingSong zakhire kon
        //age chizi nabayad pakhsh mishod masalan har do shoon khamoosh boodano be tahe list resid bayad dige play nakone
        //ke yani null kone meghdare nowPlayingSong ro
    }//new

    public static int randomGenerator(int bound) {
        Random random = new Random(8585);//ezzz:)
        return random.nextInt(bound);
    }
}
