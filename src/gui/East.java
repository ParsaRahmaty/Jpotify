package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class East extends JPanel {


    private JScrollPane scrollPane;
    private int buttonNumbers;
    ArrayList<JButton> buttons;
    ArrayList<JLabel> labels1;
    ArrayList<JLabel> labels2;
    ArrayList<JLabel> labels3;
    int label1Numbers;
    int label2Numbers;
    int label3Numbers;



    public East() throws IOException {


        labels1 = new ArrayList<>();
        labels2 = new ArrayList<>();
        labels3 = new ArrayList<>();


        buttons = new ArrayList<>();
//        setLayout(new GridLayout(0, 1, 0, -5));
        setLayout(new FlowLayout());
        setBackground(Color.BLACK);


        buttons.add(new JButton("       asd"));
        buttons.add(new JButton("asd        "));
        buttons.add(new JButton("asd"));




        labels1.add(new JLabel("xcvxcv"));
        labels1.add(new JLabel("xcvxcv"));
        labels1.add(new JLabel("xcvxcv"));



        labels2.add(new JLabel("x123123"));
        labels2.add(new JLabel("4545"));
        labels2.add(new JLabel("xcvx3434cv"));



        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));




        buttonNumbers = buttons.size();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setPreferredSize(new Dimension(128, 200));
        JPanel iconLabel = new JPanel();
        iconLabel.setLayout(new FlowLayout());
        add(buttons, labels1, labels2, labels3, mainPanel, buttonNumbers);

        add(mainPanel);
    }




    public void add(ArrayList<JButton> b, ArrayList<JLabel> l1, ArrayList<JLabel> l2, ArrayList<JLabel> l3, JPanel p, int numbers) throws IOException {
        for (int i = 0; i < numbers; i++){
            setPreferredSize(new Dimension(128, 40 * numbers));
            setSize(new Dimension(128, 1000));
            l1.get(i).setPreferredSize(new Dimension(128, 20));
            l2.get(i).setPreferredSize(new Dimension(128, 20));
            l3.get(i).setPreferredSize(new Dimension(128, 20));
//            b.get(i).setIcon(new ImageIcon("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\speaker.png"));



            b.get(i).setPreferredSize(new Dimension(128, 50));
            b.get(i).setSize(new Dimension(20, 20));


            //if user is online
            BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\speaker.jpg"));
            BufferedImage finalImg = new BufferedImage(b.get(i).getWidth(), b.get(i).getHeight(), img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, b.get(i).getWidth(), b.get(i).getHeight(),null);
            graphics2D.dispose();
            b.get(i).setIcon(new ImageIcon(finalImg));

//            b.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
            b.get(i).setHorizontalTextPosition(SwingConstants.LEFT);
            //else type the time





//            b.get(i).setPreferredSize(new Dimension(100, 100));
//            b.get(i).setSize(new Dimension(100, 100));



            p.add(b.get(i));
            p.add(l1.get(i));
            p.add(l2.get(i));
            p.add(l3.get(i));

        }
    }


}
