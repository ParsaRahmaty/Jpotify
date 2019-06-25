import gui.MainFrame;
import logic.Manager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Manager.setMainFrame(new MainFrame("Jpotify"));
    }
}
