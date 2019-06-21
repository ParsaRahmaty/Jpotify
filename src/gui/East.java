package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
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
    JPanel mainPanel;



    public East() throws IOException {
        setSize(new Dimension(128, 10000));
//        setBackground(Color.GREEN);


        labels1 = new ArrayList<>();
        labels2 = new ArrayList<>();
        labels3 = new ArrayList<>();


        buttons = new ArrayList<>();
//        setLayout(new GridLayout(0, 1, 0, -5));
//        setLayout(new FlowLayout());
        setBackground(Color.WHITE);

        {


            buttons.add(new JButton("asd"));
            buttons.add(new JButton("asd"));
            buttons.add(new JButton("asd"));
            buttons.add(new JButton("asd"));
            buttons.add(new JButton("asd"));
            buttons.add(new JButton("asd"));


            labels1.add(new JLabel("xcvxcv"));
            labels1.add(new JLabel("xcvxcv"));
            labels1.add(new JLabel("xcvxcv"));
            labels1.add(new JLabel("xcvxcv"));
            labels1.add(new JLabel("xcvxcv"));
            labels1.add(new JLabel("xcvxcv"));


            labels2.add(new JLabel("xcvx3434cv"));
            labels2.add(new JLabel("xcvx3434cv"));
            labels2.add(new JLabel("xcvx3434cv"));
            labels2.add(new JLabel("xcvx3434cv"));
            labels2.add(new JLabel("xcvx3434cv"));
            labels2.add(new JLabel("xcvx3434cv"));





        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
        labels3.add(new JLabel("xnbmhbmnbnmv"));
    }




        buttonNumbers = buttons.size();

        mainPanel = new JPanel();
//        mainPanel.setLayout(new GridLayout(0, 1));
        mainPanel.setLayout(new FlowLayout());

        JPanel iconLabel = new JPanel();
        iconLabel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.WHITE );


        add(buttons, labels1, labels2, labels3, mainPanel, buttonNumbers);

        add(mainPanel);
    }




    public void add(ArrayList<JButton> b, ArrayList<JLabel> l1, ArrayList<JLabel> l2, ArrayList<JLabel> l3, JPanel p, int numbers) throws IOException {
        for (int i = 0; i < numbers; i++){


            mainPanel.setPreferredSize(new Dimension(128, 86 * numbers));



//            setPreferredSize(new Dimension(200, 40 * numbers));
//            setPreferredSize(new Dimension(128, 10000));

            l1.get(i).setPreferredSize(new Dimension(128, 12));
            l2.get(i).setPreferredSize(new Dimension(128, 12));
            l3.get(i).setPreferredSize(new Dimension(128, 12));
            l1.get(i).setForeground(Color.BLACK);
            l2.get(i).setForeground(Color.BLACK);
            l3.get(i).setForeground(Color.BLACK);
            l1.get(i).setFont(new Font("serif", Font.BOLD, 12));
            l2.get(i).setFont(new Font("serif", Font.BOLD, 12));
            l3.get(i).setFont(new Font("serif", Font.BOLD, 12));
            b.get(i).setForeground(Color.BLACK);
            b.get(i).setBackground(Color.WHITE);
            b.get(i).setBorderPainted(false);
            b.get(i).setFocusPainted(false);






            //if user is online
            BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\speaker.jpg"));
            BufferedImage finalImg = new BufferedImage(20, 20, img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, 20, 20,null);
            graphics2D.dispose();
            b.get(i).setIcon(new ImageIcon(finalImg));




            b.get(i).setPreferredSize(new Dimension(128, 30));
//            b.get(i).setSize(new Dimension(128, 10));


//            b.get(i).setHorizontalAlignment(SwingConstants.RIGHT);
            b.get(i).setHorizontalTextPosition(SwingConstants.LEFT);
            //else type the time


            p.add(b.get(i));
            p.add(l1.get(i));
            p.add(l2.get(i));
            p.add(l3.get(i));

        }
    }


}
