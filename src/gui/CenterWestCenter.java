package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CenterWestCenter extends JPanel{
    public CenterWestCenter() throws IOException {
        setLayout(new FlowLayout());

        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\sheriffff.jpg"));
        BufferedImage finalImg = new BufferedImage(135, 210, img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, 135, 210, null);
        graphics2D.dispose();
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(finalImg));

        setBackground(Color.WHITE);
        add(label);
    }
}
