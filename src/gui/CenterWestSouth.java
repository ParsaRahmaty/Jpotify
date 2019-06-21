package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;

public class CenterWestSouth extends JPanel {
    private ArrayList<JButton> buttons1;
    private ArrayList<JButton> buttons2;
    private JButton addNewPlayList;

    private int buttonNumbers1;
    private int buttonNumbers2;


    private JFileChooser fileChooser;//fileChooser.showOpenDialog(new East());

    public CenterWestSouth() throws IOException {

        fileChooser = new JFileChooser();

        buttons1 = new ArrayList<>();
        buttons2 = new ArrayList<>();

        setLayout(new GridLayout(0, 1, 0, -5));

        JTextField textField1 = new JTextField("    PLAYLISTS");
        JTextField textField2 = new JTextField(" YOUR LIBRARY");
        textField1.setForeground(Color.WHITE);
        textField2.setForeground(Color.WHITE);

        buttons1.add(new JButton("sag"));
        buttons1.add(new JButton("sag"));
        buttons1.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));




        textField1.setEditable(false);
        textField2.setEditable(false);
        textField1.setBackground(Color.GRAY);
        textField2.setBackground(Color.GRAY);


//        textField1.setFont(new Font("Area", Font.BOLD, 12));
//        textField2.setFont(new Font("Area", Font.BOLD, 12));



        buttonNumbers1 = buttons1.size();
        buttonNumbers2 = buttons2.size();
        add(textField1);
        addButton(buttons1, buttonNumbers1);
        add(textField2);
        addButton(buttons2, buttonNumbers2);
//=====================================



        //===============================
        addNewPlayList = new JButton();
//        addNewPlayList.setBorderPainted(false);
        addNewPlayList.setPreferredSize(new Dimension(20, 20));
        addNewPlayList.setSize(new Dimension(20, 20));
        addNewPlayList.setBackground(Color.BLACK);
        JTextArea textArea = new JTextArea("New Playlist");
        textArea.setEditable(false);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);



//        BufferedImage img = ImageIO.read(getClass().getResource("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\p.jpg"));
        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\p.jpg"));
        BufferedImage finalImg = new BufferedImage(addNewPlayList.getWidth(), addNewPlayList.getHeight(), img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, addNewPlayList.getWidth(), addNewPlayList.getHeight(), null);
        graphics2D.dispose();
        addNewPlayList.setIcon(new ImageIcon(finalImg));
//        addNewPlayList.setBounds(0, 0 , 50, 50);

        JPanel p = new JPanel();
        p.add(addNewPlayList, BorderLayout.WEST);
        p.add(textArea, BorderLayout.CENTER);




        p.setBackground(Color.BLACK);

//        add(textArea);
        add(p);
//        add(addNewPlayList);

    }

    public void addButton(ArrayList<JButton> buttonsToBeAdd, int numbers){
        for (int i = 0; i < numbers; i++) {
            add(buttonsToBeAdd.get(i));
            buttonsToBeAdd.get(i).setForeground(Color.WHITE);
            buttonsToBeAdd.get(i).setBackground(Color.BLACK);
        }
    }

    public void addButton(ArrayList<JButton> buttons, JButton buttonToBeAdd){
        buttons.add(buttonToBeAdd);
    }
    //======================================
}
