package gui;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class East extends JPanel{


    private JScrollPane scrollPane;
    private int buttonNumbers;
    ArrayList<JButton> buttons;

    public East(){
        buttons = new ArrayList<>();
        setLayout(new GridLayout(0, 1));


        buttons.add(new JButton("asd"));
        buttons.add(new JButton("asd"));
        buttons.add(new JButton("asd"));



        buttonNumbers = buttons.size();
        addButton(buttons, buttonNumbers);
    }

    public void addButton(ArrayList<JButton> buttonsToBeAdd, int numbers){
        for (int i = 0; i < numbers; i++){
            add(buttons.get(i));
            buttonsToBeAdd.get(i).setForeground(Color.WHITE);
            buttonsToBeAdd.get(i).setBackground(Color.BLACK);
        }
    }

    public void addButton(ArrayList<JButton> buttons, JButton buttonToBeAdd){
        buttons.add(buttonToBeAdd);
    }
}
