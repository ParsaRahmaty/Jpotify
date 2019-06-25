package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class ListElement extends Element{
    private JButton addToPlaylist = new JButton();
    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final Color MY_GRAY2 = new Color(50, 50, 50);
    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 12);
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 10);
    private final Font FONT3 = new Font("Microsoft Sans Serif", Font.BOLD, 14);
    private final Color MY_GRAY = new Color(30, 30, 30);

    public ListElement(String imagePath) {
        PANEL_WIDTH = 5000;
        PANEL_HEIGHT = 90;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setLayout(null);
        if (imagePath == null)
            imagePath = "ICON_SOURCE\\default90.jpg";
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
        button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                button.setBorder(new BevelBorder(BevelBorder.RAISED, Color.WHITE, Color.WHITE));

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(36, 174, 239), new Color(36, 174, 239)));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(36, 174, 239), new Color(36, 174, 239)));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
            }
        });
        button.setBounds(0, 0, PANEL_HEIGHT, PANEL_HEIGHT);
        setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY));
        setBackground(new Color(50, 50, 50));
    }

    public ListElement(String imagePath, String playlistName) {
        this(imagePath);
        if (playlistName == null)
            playlistName = "";
        firstLabel = new JLabel(playlistName);
        add(firstLabel);
        firstLabel.setFont(FONT3);
        firstLabel.setBounds(110, 0, 250, 35);
        firstLabel.setForeground(Color.WHITE);
    }

    public ListElement(String imagePath, String albumName, String artistName) {
        this(imagePath, albumName);
        if (artistName == null)
            artistName = "Unknown Artist";
        secondLabel = new JLabel(artistName);
        add(secondLabel);
        secondLabel.setFont(FONT2);
        secondLabel.setBounds(110, 23, 250, 25);
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
        thirdLabel.setBounds(110, 60, 250, 25);
        thirdLabel.setForeground(Color.LIGHT_GRAY);
        SwingUsefulMethods.JButtonSetIcon(this, addToPlaylist, "ICON_SOURCE\\plus10i.png", 10, 10);
        addToPlaylist.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        addToPlaylist.setBorderPainted(false);
        addToPlaylist.setFocusPainted(false);
        addToPlaylist.setBackground(MY_GRAY2);
        addToPlaylist.setBounds(92, 5, 10, 10);
        addToPlaylist.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SwingUsefulMethods.JButtonSetIcon(ListElement.this, addToPlaylist, "ICON_SOURCE\\plus10ib.png", 10, 10);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SwingUsefulMethods.JButtonSetIcon(ListElement.this, addToPlaylist, "ICON_SOURCE\\plus10i.png", 10, 10);
            }
        });
        this.add(addToPlaylist);
        addToPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PlaylistChooser();
            }
        });
    }
}
