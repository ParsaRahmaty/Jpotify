import gui.EnterName;
import gui.MainFrame;
import logic.*;
import network.NetworkManager;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EnterName enterName = new EnterName();
        enterName.setListener(new ChangeFrameListener() {
            @Override
            public void changeFrames() throws IOException {
                Manager.setInstance(new Manager());
                Manager.getInstance().setMainFrame(new MainFrame("Jpotify", enterName.getUsername()));
                Manager.getInstance().loadObject();
                Manager.getInstance().getMainFrame().addComponents();

                for (Song song : Manager.getInstance().getSongs())
                    song.updateLostInfos();
                for (Album album : Manager.getInstance().getAlbums())
                    album.updateImage();
                for (int i = 2; i < Manager.getInstance().getPlaylists().size(); i++)
                    Manager.getInstance().getPlaylists().get(i).updateImage();
                for (Library library : Manager.getInstance().getLibraries()) {
                    Manager.getInstance().getMainFrame().getCenterWestCenter().addLibrary(library);
                }
                for (int i = 2; i < Manager.getInstance().getPlaylists().size(); i++) {
                    Manager.getInstance().getMainFrame().getCenterWestCenter().addPlaylist(Manager.getInstance().getPlaylists().get(i));
                }
                Manager.getInstance().getMainFrame().getCenterWestCenter().setFavoritePlaylist(Manager.getInstance().getPlaylists().get(0));
                Manager.getInstance().getMainFrame().getCenterWestCenter().getFavoritePlaylist().updateImage();
                for (Playlist playlist : Manager.getInstance().getPlaylists())
                    playlist.updateImage();
                enterName.dispose();
                NetworkManager networkManager = new NetworkManager();
                networkManager.run();
            }
        });
    }
}
