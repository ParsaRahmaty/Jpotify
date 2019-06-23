package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class CenterCenterNorth extends JPanel {
    private JButton button;
    private JTextField searchBar;
    private JPanel searchPanel;
    private JButton searchButton;
    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.PLAIN, 12);
    private final Color MY_GRAY = new Color(30, 30, 30);

    public CenterCenterNorth() {
        setLayout(new BorderLayout());
        setBackground(MY_GRAY);
        button = new JButton("Mohammadreza Dorudian");
        add(button, BorderLayout.EAST);
        button.setFont(FONT1);
        button.setBorderPainted(false);
        button.setBackground(MY_GRAY);
        button.setFocusPainted(false);
        button.setForeground(Color.WHITE);
        SwingUsefulMethods.JButtonSetIcon(this, button, "ICON_SOURCE\\i.png", 10, 10);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FriendList();
            }
        });
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                SwingUsefulMethods.JButtonSetIcon(CenterCenterNorth.this, button, "ICON_SOURCE\\ib.png", 10, 10);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SwingUsefulMethods.JButtonSetIcon(CenterCenterNorth.this, button, "ICON_SOURCE\\i.png", 10, 10);
            }
        });
        searchBar = new JTextField();
        searchBar.setPreferredSize(new Dimension(150, 15));
        searchBar.setBackground(MY_GRAY);
        searchBar.setFont(FONT1);
        searchBar.setForeground(Color.WHITE);
        searchBar.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(43, 43, 43), new Color(43, 43, 43)));
        new GhostText(searchBar, "Search for a Music...");

        searchButton = new JButton();
        searchButton.setBorderPainted(false);
        searchButton.setBackground(MY_GRAY);
        searchButton.setFocusPainted(false);
        searchButton.setForeground(Color.WHITE);
        SwingUsefulMethods.JButtonSetIcon(this, searchButton, "ICON_SOURCE\\search4.png", 15, 15);
        searchButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                SwingUsefulMethods.JButtonSetIcon(CenterCenterNorth.this, searchButton, "ICON_SOURCE\\search4b.png", 15, 15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                SwingUsefulMethods.JButtonSetIcon(CenterCenterNorth.this, searchButton, "ICON_SOURCE\\search4.png", 15, 15);
            }
        });

        searchPanel = new JPanel();
        searchPanel.setBackground(MY_GRAY);
        searchPanel.setLayout(new BorderLayout());
        searchPanel.add(searchBar, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.WEST);
        add(searchPanel, BorderLayout.WEST);
    }
}
