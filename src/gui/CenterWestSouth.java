package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CenterWestSouth extends JPanel {

    private int buttonNumbers1;
    private int buttonNumbers2;

    public CenterWestSouth() throws IOException {
        setBackground(Color.WHITE);

        JFileChooser fileChooser;//fileChooser.showOpenDialog(new East());
        ArrayList<JButton> buttons1 = new ArrayList<>();
        ArrayList<JButton> buttons2 = new ArrayList<>();

//        setLayout(new GridLayout(0, 1, 0, -5));
        setLayout(new FlowLayout());

        JTextField textField1 = new JTextField("    PLAYLISTS");
        JTextField textField2 = new JTextField(" YOUR LIBRARY");
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField1.setForeground(Color.BLACK);
        textField2.setForeground(Color.BLACK);
        textField1.setFont(new Font("serif", Font.BOLD, 12));
        textField2.setFont(new Font("serif", Font.BOLD, 12));
        textField1.setPreferredSize(new Dimension(100, 15));
        textField2.setPreferredSize(new Dimension(100, 15));
        textField1.setHorizontalAlignment(SwingConstants.LEFT);
        textField2.setHorizontalAlignment(SwingConstants.LEFT);

        {
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons2.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
            buttons1.add(new JButton("sag"));
        }

        JButton addNewPlayList = new JButton();
        addNewPlayList.setBackground(Color.WHITE);
        addNewPlayList.setPreferredSize(new Dimension(20, 20));
        addNewPlayList.setFocusPainted(false);
        addNewPlayList.setBorderPainted(false);
        addNewPlayList.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                addNewPlayList.setBackground(Color.cyan);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                addNewPlayList.setBackground(null);

            }
        });

        BufferedImage img = ImageIO.read(new File("C:\\Users\\admin\\IdeaProjects\\Jpotify\\src\\gui\\pp.png"));
        BufferedImage finalImg = new BufferedImage(20, 20, img.getType());
        Graphics2D graphics2D = finalImg.createGraphics();
        graphics2D.drawImage(img, 0, 0, 20, 20, null);
        graphics2D.dispose();
        addNewPlayList.setIcon(new ImageIcon(finalImg));

        JTextArea textArea = new JTextArea("New Playlist");
        textArea.setEditable(false);
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.WHITE);

        JPanel mainPanel = new JPanel();
        mainPanel.add(addNewPlayList);
        mainPanel.add(textArea);
        mainPanel.setBackground(Color.WHITE);

        JButton allPlayList = new JButton("All Playlists");
        JButton allAlbums = new JButton("All Albums");
        allAlbums.setPreferredSize(new Dimension(128, 20));
        allPlayList.setPreferredSize(new Dimension(128, 20));
        allPlayList.setBorderPainted(false);
        allAlbums.setBorderPainted(false);
        allPlayList.setFocusPainted(false);
        allAlbums.setFocusPainted(false);

        buttonNumbers1 = buttons1.size();
        buttonNumbers2 = buttons2.size();

        add(textField1);
        add(allPlayList);
        addButton(buttons1, buttonNumbers1);
        add(mainPanel);
        add(textField2);
        add(allAlbums);
        addButton(buttons2, buttonNumbers2);
    }

    private void addButton(ArrayList<JButton> buttonsToBeAdd, int numbers){

        setPreferredSize(new Dimension(130,35 * (buttonNumbers1+buttonNumbers2) + 130));

        for (int i = 0; i < numbers; i++) {
            buttonsToBeAdd.get(i).setPreferredSize(new Dimension(130, 30));
            buttonsToBeAdd.get(i).setBorderPainted(false);
            buttonsToBeAdd.get(i).setFocusPainted(false);
            buttonsToBeAdd.get(i).setHorizontalAlignment(SwingConstants.CENTER);
            buttonsToBeAdd.get(i).setForeground(Color.BLACK);
            buttonsToBeAdd.get(i).setBackground(Color.WHITE);

            add(buttonsToBeAdd.get(i));
        }
    }

    public void addButton(ArrayList<JButton> buttons, JButton buttonToBeAdd){
        buttons.add(buttonToBeAdd);
    }
}
