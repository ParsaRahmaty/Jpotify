package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame(String label) {
        super(label);
        setLayout(new BorderLayout());
        setSize(800, 600);
        add(new JScrollPane(new CenterCenterCenter(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        add(new CenterCenterNorth(), BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
