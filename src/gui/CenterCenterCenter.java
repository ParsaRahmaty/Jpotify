package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class CenterCenterCenter extends JPanel {
    public CenterCenterCenter() {
        Color myGray = new Color(50,50,50);
        setBackground(myGray);
        setLayout(new ModifiedFlowLayout());
        WindowElement windowElement1 = new WindowElement("ICON_SOURCE\\1.jpg", "Remember We Die", "Memento Mori", "Gemini Syndrome");
        WindowElement windowElement2 = new WindowElement("ICON_SOURCE\\2.jpg", "The Eternal Sleep of Slugs", "Circles", "Frame");
        WindowElement windowElement3 = new WindowElement("ICON_SOURCE\\3.jpg", "Poker", "Without Looking Back", null);
        WindowElement windowElement4 = new WindowElement("ICON_SOURCE\\4.jpg", "ProzaKc Blues", "The ConstruKction Of Light", "kING Crimson");
        WindowElement windowElement5 = new WindowElement(null, "Carnivore", "Transmissions (Deluxe Edition)", "Starset");
        add(windowElement1, ModifiedFlowLayout.LEFT);
        add(windowElement2, ModifiedFlowLayout.LEFT);
        add(windowElement3, ModifiedFlowLayout.LEFT);
        add(windowElement4, ModifiedFlowLayout.LEFT);
        add(windowElement5, ModifiedFlowLayout.LEFT);
    }
}
