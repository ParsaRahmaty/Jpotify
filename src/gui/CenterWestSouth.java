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
    JPanel mainpanel;
    private ArrayList<JButton> buttons1;
    private ArrayList<JButton> buttons2;
    private JButton addNewPlayList;

    private int buttonNumbers1;
    private int buttonNumbers2;


    private JFileChooser fileChooser;//fileChooser.showOpenDialog(new East());

    public CenterWestSouth() throws IOException {

//        setSize(new Dimension(128, 10000));




//        setSize(new Dimension(100, 1000));

//        setSize(new Dimension(128, 100));
        mainpanel = new JPanel();



        fileChooser = new JFileChooser();

        buttons1 = new ArrayList<>();
        buttons2 = new ArrayList<>();

//        setLayout(new GridLayout(0, 1, 0, -5));
        setLayout(new FlowLayout());

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
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));
        buttons2.add(new JButton("sag"));


        buttonNumbers1 = buttons1.size();
        buttonNumbers2 = buttons2.size();



        setPreferredSize(new Dimension(130, 31 * (buttonNumbers1+buttonNumbers2)));





        textField1.setEditable(false);
        textField2.setEditable(false);
        textField1.setBackground(Color.GRAY);
        textField2.setBackground(Color.GRAY);


        textField1.setFont(new Font("serif", Font.BOLD, 12));
        textField2.setFont(new Font("serif", Font.BOLD, 12));
        textField1.setPreferredSize(new Dimension(100, 15));
        textField2.setPreferredSize(new Dimension(100, 15));






        add(textField1);
        addButton(buttons1, buttonNumbers1);
        add(textField2);
        addButton(buttons2, buttonNumbers2);


        addNewPlayList = new JButton();


//        addNewPlayList.setBorderPainted(false);
//        addNewPlayList.setPreferredSize(new Dimension(20, 20));
//        addNewPlayList.setSize(new Dimension(20, 20));
        addNewPlayList.setBackground(Color.YELLOW);
        JTextArea textArea = new JTextArea("New Playlist");
        textArea.setEditable(false);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);

        addNewPlayList.setPreferredSize(new Dimension(22, 22));


        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\p.jpg"));
        BufferedImage finalImg = new BufferedImage(20, 20, img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, 20, 20, null);
        graphics2D.dispose();
        addNewPlayList.setIcon(new ImageIcon(finalImg));

        addNewPlayList.setFocusPainted(false);
        addNewPlayList.setBorderPainted(false);



        mainpanel = new JPanel();
//        p.setLayout();
        mainpanel.add(addNewPlayList);
        mainpanel.add(textArea);



        mainpanel.setBackground(Color.GREEN);


        add(mainpanel);
//        setSize(new Dimension(130, 100000));


    }

    public void addButton(ArrayList<JButton> buttonsToBeAdd, int numbers){




//        setPreferredSize(new Dimension(100, 30 * numbers));


//        setPreferredSize(new Dimension(128, 40 * numbers));
//        mainpanel.setPreferredSize(new Dimension(128, 40 * numbers));

//        setSize(new Dimension(128, 100000));


        for (int i = 0; i < numbers; i++) {


//            mainpanel.setSize(new Dimension(130, 40 * numbers));
//            setSize(new Dimension(128, numbers));
            mainpanel.setPreferredSize(new Dimension(130, 40 * numbers));

            buttonsToBeAdd.get(i).setPreferredSize(new Dimension(130, 20));
            buttonsToBeAdd.get(i).setBorderPainted(false);
            buttonsToBeAdd.get(i).setFocusPainted(false);
            //            buttonsToBeAdd.get(i).setSize(new Dimension(20, 20));

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
