import gui.CenterWestCenter;
import gui.CenterWestSouth;
import gui.East;
import gui.ScrollBar;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame f1 = new JFrame();
        f1.setLayout(new BorderLayout());
        f1.setBackground(Color.black);
        f1.setForeground(Color.BLACK);
        f1.setSize(1132, 700);
        f1.setLocation(200, 50);

        ScrollBar ll = new ScrollBar(new East());

        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(new ScrollBar(new CenterWestSouth()), BorderLayout.CENTER);
        p.add(new CenterWestCenter(), BorderLayout.SOUTH);

        f1.add(ll, BorderLayout.EAST);
        f1.add(p, BorderLayout.WEST);

        f1.setVisible(true);
    }
}
