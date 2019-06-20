package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ListElement extends Element{
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 12);
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 10);
    private final Font FONT3 = new Font("Microsoft Sans Serif", Font.BOLD, 14);

    public ListElement(String imagePath) {
        PANEL_WIDTH = 5000;
        PANEL_HEIGHT = 90;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        if (imagePath == null)
            imagePath = "default.jpg";
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(imagePath));
            BufferedImage finalImg = new BufferedImage(PANEL_HEIGHT, PANEL_HEIGHT, img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, PANEL_HEIGHT, PANEL_HEIGHT, null);
            graphics2D.dispose();
            button.setIcon(new ImageIcon(finalImg));
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(button);
        button.setBounds(0, 0, PANEL_HEIGHT, PANEL_HEIGHT);
        Color myGray = new Color(43, 43, 43);
        setBackground(myGray);
    }

    public ListElement(String imagePath, String playlistName) {
        this(imagePath);
        if (playlistName == null)
            playlistName = "";
        firstLabel = new JLabel(playlistName);
        add(firstLabel);
        firstLabel.setFont(FONT3);
        firstLabel.setBounds(110, 0, 500, 35);
        firstLabel.setForeground(Color.WHITE);
    }

    public ListElement(String imagePath, String albumName, String artistName) {
        this(imagePath, albumName);
        if (artistName == null)
            artistName = "Unknown Artist";
        secondLabel = new JLabel(artistName);
        add(secondLabel);
        secondLabel.setFont(FONT2);
        secondLabel.setBounds(110, 23, 500, 25);
        secondLabel.setForeground(Color.LIGHT_GRAY);
    }

    public ListElement(String imagePath, String songName, String albumName, String artistName) {
        this(imagePath, songName, artistName);
        if (albumName == null)
            albumName = "Unknown Album";
        firstLabel.setFont(FONT1);
        thirdLabel = new JLabel(albumName);
        add(thirdLabel);
        thirdLabel.setFont(FONT2);
        thirdLabel.setBounds(110, 60, 500, 25);
        thirdLabel.setForeground(Color.LIGHT_GRAY);
    }
}
