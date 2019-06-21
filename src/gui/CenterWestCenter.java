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
//        img = new ImageIcon("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\sabab.jpg");
//        label.setIcon(img);
        setLayout(new FlowLayout());

        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\sabab.jpg"));
        BufferedImage finalImg = new BufferedImage(128, 200, img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, 128, 200, null);
        graphics2D.dispose();
        label.setIcon(new ImageIcon(finalImg));
        setBackground(Color.GREEN);


        add(label);
    }
}
