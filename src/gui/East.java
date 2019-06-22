package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class East extends JPanel {


    private int buttonNumbers;
    private JPanel mainPanel;



    public East() throws IOException {
        setSize(new Dimension(128, 10000));
//        setBackground(Color.GREEN);


        ArrayList<JButton> buttons = new ArrayList<>();

        ArrayList<JLabel> labels1 = new ArrayList<>();
        ArrayList<JLabel> labels2 = new ArrayList<>();
        ArrayList<JLabel> labels3 = new ArrayList<>();

        setBackground(Color.WHITE);

        {
            buttons.add(new JButton("sage pir"));
            buttons.add(new JButton("sage mariz"));
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




    private void add(ArrayList<JButton> b, ArrayList<JLabel> l1, ArrayList<JLabel> l2, ArrayList<JLabel> l3, JPanel p, int numbers) throws IOException {

        JLabel l = new JLabel("Friend Activity");
        l.setPreferredSize(new Dimension(128, 30));
        l.setFont(new Font("serif", Font.BOLD, 16));
        p.add(l);


        for (int i = 0; i < numbers; i++){


            mainPanel.setPreferredSize(new Dimension(128, 97 * numbers + 30));



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


//            l1.get(i).setHorizontalTextPosition(SwingConstants.CENTER);
//            l2.get(i).setHorizontalTextPosition(SwingConstants.CENTER);
//            l3.get(i).setHorizontalTextPosition(SwingConstants.CENTER);








            //if user is online
            BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\speaker.jpg"));
            BufferedImage finalImg = new BufferedImage(20, 20, img.getType());
            Graphics2D graphics2D = finalImg.createGraphics();
            graphics2D.drawImage(img, 0, 0, 20, 20,null);
            graphics2D.dispose();
//            b.get(i).setIcon(new ImageIcon(finalImg));




            b.get(i).setPreferredSize(new Dimension(90, 30));
            b.get(i).setHorizontalTextPosition(SwingConstants.LEFT);
            //else type the time
            //=========================================
            JPanel innerPanel = new JPanel();
            innerPanel.setPreferredSize(new Dimension(128, 40));
            innerPanel.setLayout(new FlowLayout());
            innerPanel.add(b.get(i));
            JLabel label = new JLabel();
            label.setIcon(new ImageIcon(finalImg));
            innerPanel.add(label);








            innerPanel.setBackground(Color.LIGHT_GRAY);
            b.get(i).setBackground(Color.LIGHT_GRAY);





//            p.add(b.get(i));

            p.add(innerPanel);
            p.add(l1.get(i));
            p.add(l2.get(i));
            p.add(l3.get(i));

        }
    }


}
