package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Element extends JPanel {
    private final int COMP_WIDTH = 200;
    private final int COMP_HEIGHT = 250;
    private JButton button = new JButton();
    private JLabel firstLabel;
    private JLabel secondLabel;
    private JLabel thirdLabel;
    private final Font font1 = new Font("Microsoft Sans Serif", Font.BOLD, 10);
    private final Font font2 = new Font("Microsoft Sans Serif", Font.PLAIN, 9);
    private final Font font3 = new Font("Microsoft Sans Serif", Font.BOLD, 12);

    public Element(String imagePath) {
        setPreferredSize(new Dimension(COMP_WIDTH, COMP_HEIGHT));
        setLayout(null);
        if (imagePath == null)
            imagePath = "default.jpg";
        try {
            BufferedImage img = ImageIO.read(getClass().getResource(imagePath));
            BufferedImage finalImg = new BufferedImage(COMP_WIDTH, COMP_WIDTH, img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, COMP_WIDTH, COMP_WIDTH, null);
            graphics2D.dispose();
            button.setIcon(new ImageIcon(finalImg));
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(button);
        button.setBounds(0, 0, COMP_WIDTH, COMP_WIDTH);
        Color myGray = new Color(40, 40, 40);
        setBackground(myGray);
    }

    public Element(String imagePath, String playlistName) {
        this(imagePath);
        if (playlistName == null)
            playlistName = "";
        firstLabel = new JLabel(playlistName);
        add(firstLabel);
        firstLabel.setFont(font3);
        firstLabel.setBounds(1, 200, 200, 20);
        firstLabel.setForeground(Color.WHITE);
    }

    public Element(String imagePath, String albumName, String artistName) {
        this(imagePath, albumName);
        if (artistName == null)
            artistName = "Unknown Artist";
        secondLabel = new JLabel(artistName);
        add(secondLabel);
        secondLabel.setFont(font2);
        secondLabel.setBounds(1, 215, 200, 15);
        secondLabel.setForeground(Color.LIGHT_GRAY);
    }

    public Element(String imagePath, String songName, String albumName, String artistName) {
        this(imagePath, songName, artistName);
        if (albumName == null)
            albumName = "Unknown Album";
        firstLabel.setFont(font1);
        thirdLabel = new JLabel(albumName);
        add(thirdLabel);
        thirdLabel.setFont(font2);
        thirdLabel.setBounds(1, 232, 200, 15);
        thirdLabel.setForeground(Color.LIGHT_GRAY);
    }
}
