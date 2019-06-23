package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CenterWestCenter extends JPanel {

    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 10);
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 10);
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
        addButton("All Playlist", null, 0, SwingConstants.CENTER, 0);
        addButton(" Mememnto Mori", "ICON_SOURCE\\playlisti",  15, SwingConstants.LEFT, 1);
        addButton(" Transmissions", "ICON_SOURCE\\playlisti", 15, SwingConstants.LEFT, 1);
        addButton(" Nevermind", "ICON_SOURCE\\playlisti", 15, SwingConstants.LEFT, 1);
        addLabel("All Libraries", SwingConstants.CENTER, 0);
        JButton newLibrary = addButton("New Library", "ICON_SOURCE\\plusi", 8, SwingConstants.CENTER, 1);
        newLibrary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.showOpenDialog(CenterWestCenter.this);
            }
        });
        addButton("All Songs", null, 0, SwingConstants.CENTER, 2);
        addButton("All Albums", null, 0, SwingConstants.CENTER, 3);
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
