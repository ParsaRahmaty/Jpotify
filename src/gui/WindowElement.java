package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WindowElement extends Element {
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 10);
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 9);
    private final Font FONT3 = new Font("Microsoft Sans Serif", Font.BOLD, 12);

    public WindowElement(String imagePath) {
        PANEL_WIDTH = 200;
        PANEL_HEIGHT = 250;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        if (imagePath == null)
            imagePath = "default.jpg";
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(imagePath));
            BufferedImage finalImg = new BufferedImage(PANEL_WIDTH, PANEL_WIDTH, img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, PANEL_WIDTH, PANEL_WIDTH, null);
            graphics2D.dispose();
            button.setIcon(new ImageIcon(finalImg));
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(button);
        button.setBounds(0, 0, PANEL_WIDTH, PANEL_WIDTH);
        Color myGray = new Color(50, 50, 50);
        setBackground(myGray);
    }

    public WindowElement(String imagePath, String playlistName) {
        this(imagePath);
        if (playlistName == null)
            playlistName = "";
        firstLabel = new JLabel(playlistName);
        add(firstLabel);
        firstLabel.setFont(FONT3);
        firstLabel.setBounds(1, 200, 200, 20);
        firstLabel.setForeground(Color.WHITE);
    }

    public WindowElement(String imagePath, String albumName, String artistName) {
        this(imagePath, albumName);
        if (artistName == null)
            artistName = "Unknown Artist";
        secondLabel = new JLabel(artistName);
        add(secondLabel);
        secondLabel.setFont(FONT2);
        secondLabel.setBounds(1, 215, 200, 15);
        secondLabel.setForeground(Color.LIGHT_GRAY);
    }

    public WindowElement(String imagePath, String songName, String albumName, String artistName) {
        this(imagePath, songName, artistName);
        if (albumName == null)
            albumName = "Unknown Album";
        firstLabel.setFont(FONT1);
        thirdLabel = new JLabel(albumName);
        add(thirdLabel);
        thirdLabel.setFont(FONT2);
        thirdLabel.setBounds(1, 232, 200, 15);
        thirdLabel.setForeground(Color.LIGHT_GRAY);
    }
}
