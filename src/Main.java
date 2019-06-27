import gui.EnterName;
import gui.MainFrame;
import logic.ChangeFrameListener;
import logic.Manager;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EnterName enterName = new EnterName();
        enterName.setListener(new ChangeFrameListener() {
            @Override
            public void changeFrames() throws IOException {
                Manager.setMainFrame(new MainFrame("Jpotify", enterName.getUsername()));
                Manager.getMainFrame().addComponents();
                enterName.dispose();
            }
        });
    }
}
