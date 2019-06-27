package gui;

import logic.Library;
import logic.Manager;
import logic.Playlist;

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

    private JButton allPlaylists;
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

    public CenterWestCenter() {
        ELEMENT_WIDTH = 145;
        ELEMENT_HEIGHT = 25;
        this.setLayout(new ModifiedFlowLayout());
        setBackground(MY_GRAY);
        allLibraries = makeLabel("All Libraries", SwingConstants.CENTER);
        newLibrary = makeButton("New Library", "ICON_SOURCE\\plusi", 8, SwingConstants.CENTER, ELEMENT_WIDTH, ELEMENT_HEIGHT, true);
        newLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.mp3", "mp3", "mp3");
                fileChooser.setFileFilter(filter);
                fileChooser.setDialogTitle("Choose a Path");
                int result = fileChooser.showSaveDialog(newLibrary);
                File file = fileChooser.getSelectedFile();
                while (result == JFileChooser.APPROVE_OPTION && file.isFile() && !file.getAbsolutePath().endsWith(".mp3")) {
                    JOptionPane.showMessageDialog(null, "The selected file should only have mp3 format");
                    result = fileChooser.showSaveDialog(newLibrary);
                    file = fileChooser.getSelectedFile();
                }
                if (result == JFileChooser.APPROVE_OPTION) {
                    Library library = new Library(file);
                    Manager.addLibrary(library);
                    System.out.println(Manager.getSongs().size());
                }
            }
        });
        allSongs = makeButton("All Songs", null, 0, SwingConstants.CENTER, ELEMENT_WIDTH, ELEMENT_HEIGHT, true);
        allPlaylists = makeButton("All Playlists", null, 0, SwingConstants.CENTER, ELEMENT_WIDTH, ELEMENT_HEIGHT, true);
        newPlaylist = makeButton("New Playlist", "ICON_SOURCE\\plusi", 8, SwingConstants.CENTER, ELEMENT_WIDTH, ELEMENT_HEIGHT, true);
        newPlaylist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewPlaylist newPlaylist = new NewPlaylist();
            }
        });
        allAlbums = makeButton("All Albums", null, 0, SwingConstants.CENTER, ELEMENT_WIDTH, ELEMENT_HEIGHT, true);
        setBounds(0, 0, 130, 0);
        add(allLibraries, 0);
        add(newLibrary, 1);
        add(allSongs, 2);
        add(allAlbums, 3);
        add(allPlaylists, 4);
        add(newPlaylist, 5);
        addLibrary(new Library(new File("E:\\New Folder")));
    }

    private JButton makeButton(String text, String imagePath, int width, int alignment, int buttonWidth, int buttonHeight, boolean shouldFlash) {
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
                    if (shouldFlash)
                        button.setBackground(new Color(43, 43, 43));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    SwingUsefulMethods.JButtonSetIcon(CenterWestCenter.this, button, imagePath + ".png", width, width);
                    if (shouldFlash)
                        button.setBackground(MY_GRAY);
                }
            });
        } else {
            button.setFont(FONT1);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    if (shouldFlash)
                        button.setBackground(new Color(43, 43, 43));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    if (shouldFlash)
                        button.setBackground(MY_GRAY);
                }
            });
        }
        button.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        button.setHorizontalAlignment(alignment);
        return button;
    }

    private JLabel makeLabel(String text, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(FONT1);
        label.setBackground(MY_GRAY);
        label.setForeground(Color.GRAY);
        label.setPreferredSize(new Dimension(ELEMENT_WIDTH, ELEMENT_HEIGHT));
        label.setHorizontalAlignment(alignment);
        return label;
    }

    private void addLibrary(Library library) {
        JPanel panel = new JPanel();
        add(panel, 1);
        panel.setBackground(Color.WHITE);
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(ELEMENT_WIDTH, ELEMENT_HEIGHT));
        JButton button = makeButton(library.getPath().substring(library.getPath().lastIndexOf("\\") + 1), "ICON_SOURCE\\libraryi", 15, SwingConstants.LEFT, ELEMENT_WIDTH - 25, ELEMENT_HEIGHT, true);
        panel.add(button, BorderLayout.CENTER);
        JButton removeButton = makeButton("", "ICON_SOURCE\\removei", 15, SwingConstants.CENTER, 25, ELEMENT_HEIGHT, false);
        panel.add(removeButton, BorderLayout.EAST);
    }
}
