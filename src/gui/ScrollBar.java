package gui;
import javax.swing.*;
import java.awt.*;
public class ScrollBar extends JPanel {
    JScrollPane scroll;
    public ScrollBar(JPanel panelToBeAdd) {
        setLayout(new BorderLayout());
        scroll = new JScrollPane();
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setViewportView(panelToBeAdd);
        add(scroll, BorderLayout.CENTER);
    }
}
