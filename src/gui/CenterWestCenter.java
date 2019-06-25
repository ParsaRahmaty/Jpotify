package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CenterWestCenter extends JPanel {

    private JButton allPlaylist;
    private JButton allSongs;
    private JButton allAlbums;
    private JButton newLibrary;
    private JButton newPlaylist;
    private JLabel allLibraries;

    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 10);
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 11);
    private final Color MY_GRAY = new Color(30, 30, 30);
    private final int ELEMENT_WIDTH;
    private final int ELEMENT_HEIGHT;
    private ArrayList<Component> myComponents = new ArrayList<>();

    public CenterWestCenter() {
        ELEMENT_WIDTH = 145;
        ELEMENT_HEIGHT = 25;
        setLayout(new BorderLayout());
        this.setLayout(new ModifiedFlowLayout());
        setBackground(MY_GRAY);
        allLibraries = addLabel("All Libraries", SwingConstants.CENTER, 0);
        newLibrary = addButton("New Library", "ICON_SOURCE\\plusi", 8, SwingConstants.CENTER, 1);
        newLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.mp3", "mp3", "mp3");
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogTitle("Choose a Path");
                fileChooser.showOpenDialog(newLibrary);
            }
        });
        allSongs = addButton("All Songs", null, 0, SwingConstants.CENTER, 2);
        allPlaylist = addButton("All Playlist", null, 0, SwingConstants.CENTER, 3);
        addButton("Heavy Metal", "ICON_SOURCE\\playlisti",  15, SwingConstants.LEFT, 4);
        addButton("Hard Rock", "ICON_SOURCE\\playlisti", 15, SwingConstants.LEFT, 5);
        addButton("Favorite", "ICON_SOURCE\\playlisti", 15, SwingConstants.LEFT, 6);
        newPlaylist = addButton("New Playlist", "ICON_SOURCE\\plusi", 8, SwingConstants.CENTER, 7);
        newPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPlaylist newPlaylist = new NewPlaylist();
            }
        });
        allAlbums = addButton("All Albums", null, 0, SwingConstants.CENTER, 8);
        addButton("Nevermind", "ICON_SOURCE\\albumi", 15, SwingConstants.LEFT, 9);
        setBounds(0, 0, 130, 0);
    }

    public JButton addButton(String text, String imagePath, int width, int alignment, int index) {
        JButton button = new JButton(text);
        button.setBorderPainted(false);
        button.setBackground(MY_GRAY);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        if (imagePath != null) {
            SwingUsefulMethods.JButtonSetIcon(this, button, imagePath + ".png", width, width);
            button.setFont(FONT2);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    SwingUsefulMethods.JButtonSetIcon(CenterWestCenter.this, button, imagePath + "b.png", width, width);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    SwingUsefulMethods.JButtonSetIcon(CenterWestCenter.this, button, imagePath + ".png", width, width);
                }
            });
        } else {
            button.setFont(FONT1);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    button.setBackground(new Color(43, 43, 43));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    button.setBackground(MY_GRAY);
                }
            });
        }
        button.setPreferredSize(new Dimension(ELEMENT_WIDTH, ELEMENT_HEIGHT));
        button.setHorizontalAlignment(alignment);
        myComponents.add(index, button);
        this.add(button, index);
        return button;
    }

    public JLabel addLabel(String text, int alignment, int index) {
        JLabel label = new JLabel(text);
        label.setFont(FONT1);
        label.setBackground(MY_GRAY);
        label.setForeground(Color.GRAY);
        label.setPreferredSize(new Dimension(ELEMENT_WIDTH, ELEMENT_HEIGHT));
        label.setHorizontalAlignment(alignment);
        myComponents.add(index, label);
        this.add(label, index);
        return label;
    }

    public ArrayList<Component> getMyComponents() {
        return myComponents;
    }
}
