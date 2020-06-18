package gui;

import logic.Library;
import logic.Manager;

import javax.swing.*;

public class ImportLibrary extends Thread {

    private Library library;
    private boolean isRefreshing;

    public ImportLibrary(Library library, boolean isRefreshing) {
        this.library = library;
        this.isRefreshing = isRefreshing;
    }

    @Override
    public void run() {
        Manager.getInstance().getMainFrame().getCenterWestCenter().disableButtons();
        Manager.getInstance().getMainFrame().getCenterWestCenter().setVisible(false);
        Manager.getInstance().getMainFrame().getCenterWestCenter().setVisible(true);
        Manager.getInstance().importLibrarySongs(library);
        Manager.getInstance().getMainFrame().getCenterWestCenter().remove(Manager.getInstance().getLibraries().size());
        Manager.getInstance().getMainFrame().getCenterWestCenter().addLibrary(library);
        if (isRefreshing) {
            int size = Manager.getInstance().getNowPlaying().size();
            for (int i = 0; i < size; i++)
                Manager.getInstance().getNowPlaying().remove(0);
            JOptionPane.showMessageDialog(null, "Library successfully refreshed!");
        }
        Manager.getInstance().getMainFrame().getCenterWestCenter().enableButtons();
        Manager.getInstance().getMainFrame().getCenterWestCenter().setVisible(false);
        Manager.getInstance().getMainFrame().getCenterWestCenter().setVisible(true);
    }
}
