package gui;

import logic.Manager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    private South south;
    private CenterWestCenter centerWestCenter;
    private CenterWestSouth centerWestSouth;
    private CenterCenterNorth centerCenterNorth;
    private CenterCenterCenter centerCenterCenter;
    private String username;
    private final Color MY_GRAY = new Color(30, 30, 30);

    public MainFrame(String label, String username) {
        super(label);
        this.username = username;
    }

    public void addComponents() throws IOException {
        JPanel center = new JPanel();
        JPanel centerCenter = new JPanel();
        JPanel centerWest = new JPanel();
        setLayout(new BorderLayout());
        setSize(800, 600);
        center.setLayout(new BorderLayout());
        centerWest.setLayout(new BorderLayout());
        centerCenter.setLayout(new BorderLayout());

        center.setBackground(MY_GRAY);
        centerCenter.setBackground(MY_GRAY);
        centerWest.setBackground(MY_GRAY);

        add(center, BorderLayout.CENTER);

        south = new South();
        add(south, BorderLayout.SOUTH);

        center.add(centerCenter, BorderLayout.CENTER);
        center.add(centerWest, BorderLayout.WEST);

        centerWestCenter = new CenterWestCenter();
        JScrollPane scrollPane = new JScrollPane(centerWestCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerWest.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(MY_GRAY);
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        SwingUsefulMethods.paintScrollPane(scrollPane, new Color(45, 45, 45), new Color(30, 30, 30));

        centerWestSouth = new CenterWestSouth();
        centerWest.add(centerWestSouth, BorderLayout.SOUTH);
        centerCenterNorth = new CenterCenterNorth();
        centerCenter.add(centerCenterNorth, BorderLayout.NORTH);
        centerCenterCenter = new CenterCenterCenter();
        JScrollPane scrollPane1 = new JScrollPane(centerCenterCenter, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerCenter.add(scrollPane1, BorderLayout.CENTER);
        scrollPane1.setBackground(MY_GRAY);
        SwingUsefulMethods.paintScrollPane(scrollPane1, new Color(35, 35, 35), new Color(50, 50, 50));
        scrollPane1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    Manager.getInstance().saveObject();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                super.windowClosing(e);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CenterCenterCenter getCenterCenterCenter() {
        return centerCenterCenter;
    }

    public CenterCenterNorth getCenterCenterNorth() {
        return centerCenterNorth;
    }

    public CenterWestCenter getCenterWestCenter() {
        return centerWestCenter;
    }

    public CenterWestSouth getCenterWestSouth() {
        return centerWestSouth;
    }

    public South getSouth() {
        return south;
    }
}
