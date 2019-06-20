package gui;

import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.ArrayList;

public class CenterWestSouth extends JPanel {
    private ArrayList<JButton> buttons1;
    private ArrayList<JButton> buttons2;
    private JButton addNewPlayList;

    private int buttonNumbers1;
    private int buttonNumbers2;
    public CenterWestSouth(){


        buttons1 = new ArrayList<>();
        buttons2 = new ArrayList<>();

        setLayout(new GridLayout(0, 1));
        JTextField textField1 = new JTextField("PLAYLISTS");
        JTextField textField2 = new JTextField("YOUR LIBRARY");
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
        addNewPlayList = new JButton();
        JPanel panel = new JPanel();
        panel.add(addNewPlayList);
        panel.add(new JTextArea("New Playlist"));
        add(panel);

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
