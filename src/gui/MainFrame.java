package gui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    private final Color MY_GRAY = new Color(30, 30, 30);

    public MainFrame(String label) throws IOException {
        super(label);
        setLayout(new BorderLayout());
        setSize(800, 600);
        JPanel center = new JPanel();
        JPanel centerCenter = new JPanel();
        JPanel centerWest = new JPanel();

        center.setLayout(new BorderLayout());
        centerWest.setLayout(new BorderLayout());
        centerCenter.setLayout(new BorderLayout());

        center.setBackground(MY_GRAY);
        centerCenter.setBackground(MY_GRAY);
        centerWest.setBackground(MY_GRAY);

        add(center, BorderLayout.CENTER);

        JScrollPane scrollPane2 = new JScrollPane(new East(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane2, BorderLayout.EAST);
        scrollPane2.setBackground(MY_GRAY);
        SwingUsefulMethods.paintScrollPane(scrollPane2, Color.LIGHT_GRAY, Color.LIGHT_GRAY, new Color(60, 60, 60));
        scrollPane2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        add(new South("The Eternal Sleep of Slugs", "Circles", "Frame"), BorderLayout.SOUTH);

        center.add(centerCenter, BorderLayout.CENTER);
        center.add(centerWest, BorderLayout.WEST);

        JScrollPane scrollPane = new JScrollPane(new CenterWestCenter(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerWest.add(scrollPane, BorderLayout.CENTER);
        scrollPane.setBackground(MY_GRAY);
        SwingUsefulMethods.paintScrollPane(scrollPane, Color.LIGHT_GRAY, Color.LIGHT_GRAY, new Color(30, 30, 30));
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        centerWest.add(new CenterWestSouth(), BorderLayout.SOUTH);
        centerCenter.add(new CenterCenterNorth(), BorderLayout.NORTH);
        JScrollPane scrollPane1  = new JScrollPane(new CenterCenterCenter(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        centerCenter.add(scrollPane1, BorderLayout.CENTER);
        scrollPane1.setBackground(MY_GRAY);
        SwingUsefulMethods.paintScrollPane(scrollPane1, Color.LIGHT_GRAY, Color.LIGHT_GRAY, new Color(30, 30, 30));
        scrollPane1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(50, 50, 50), new Color(50, 50, 50)));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
