package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;

public class NewPlaylist extends JFrame {
    private JTextField textField = new JTextField("New Playlist");
    private JLabel label = new JLabel("Name your playlist");
    private JButton button = new JButton();
    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 11);
    private final Font FONT1 = new Font("Microsoft Sans Serif", Font.BOLD, 11);
    private final Color MY_GRAY = new Color(30, 30, 30);
    private static boolean isOpen = false;

    public NewPlaylist() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                isOpen = false;
            }
        });
        if (!isOpen) {
            setBackground(MY_GRAY);
            this.getContentPane().setBackground(MY_GRAY);
            setLayout(null);
            setSize(290, 100);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
            isOpen = true;
            setResizable(false);
            add(label, BorderLayout.NORTH);
            label.setHorizontalAlignment(SwingConstants.LEFT);
            label.setBounds(5, 0, 240, 25);
            label.setForeground(Color.WHITE);
            label.setFont(FONT1);

            add(textField, BorderLayout.CENTER);
            textField.setBounds(5, 25, 240, 25);
            textField.setBackground(MY_GRAY);
            textField.setForeground(Color.WHITE);
            textField.setFont(FONT2);
            textField.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));

            button.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
            button.setBackground(MY_GRAY);
            button.setFocusPainted(false);
            button.setFont(FONT2);
            button.setForeground(Color.WHITE);
            button.setBounds(245, 25, 25, 25);
            add(button, BorderLayout.EAST);
            SwingUsefulMethods.JButtonSetIcon(this, button, "ICON_SOURCE\\ticki.png", 20, 20);
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    SwingUsefulMethods.JButtonSetIcon(NewPlaylist.this, button, "ICON_SOURCE\\tickib.png", 20, 20);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    SwingUsefulMethods.JButtonSetIcon(NewPlaylist.this, button, "ICON_SOURCE\\ticki.png", 20, 20);
                }
            });
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    isOpen = false;
                    NewPlaylist.this.dispose();
                }
            });

            setVisible(true);
        }
    }
}