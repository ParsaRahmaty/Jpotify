package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CenterWestCenter extends JPanel{
    ImageIcon img;
    JLabel label = new JLabel();
    public CenterWestCenter() throws IOException {
        img = new ImageIcon("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\sabab.jpg");
//        label.setIcon(img);

        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\sabab.jpg"));
        BufferedImage finalImg = new BufferedImage(100, 150, img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, 100, 150, null);
        graphics2D.dispose();
        label.setIcon(new ImageIcon(finalImg));


        add(label);
    }
}
