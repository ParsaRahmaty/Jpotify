package gui;

import logic.Manager;
import logic.Options;
import logic.Song;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicMenuUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class South extends JPanel {
    private JButton playPauseButton;
    private JButton nextSongButton;
    private JButton previousSongButton;
    private JButton shuffleButton;
    private JButton repeatButton;
    private JButton listButton;
    private JButton windowButton;
    private JButton compactMode;
    private JProgressBar seekBar = new JProgressBar();
    private JSlider volume;
    private JLabel songName;
    private JLabel albumName;
    private JLabel artistName;
    private MusicTime timeElapsed;
    private MusicTime timeTotal;
    private boolean isPlaying = true;
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    private boolean isListed = false;
    private boolean isCompact = false;

    private Options options;
    private Thread logicThread;

    private final Font FONT2 = new Font("Microsoft Sans Serif", Font.PLAIN, 9);
    private final Font FONT3 = new Font("Microsoft Sans Serif", Font.BOLD, 11);
    private final Color MY_GRAY = new Color(30, 30, 30);

    public static JLabel elapsed = new JLabel();

    public South(String songName, String albumName, String artistName) {
        playSong("E:\\8.mp3");
        Manager.setNowPlayingSong(new Song("E:\\8.mp3")); //Edited

        setLayout(new BorderLayout());
        setBackground(MY_GRAY);

        JPanel leftPanel = new JPanel();
        add(leftPanel, BorderLayout.WEST);
        leftPanel.setBackground(MY_GRAY);
        leftPanel.setLayout(null);
        leftPanel.setPreferredSize(new Dimension(150, 70));
        this.songName = new JLabel(songName);
        this.albumName = new JLabel(albumName);
        this.artistName = new JLabel(artistName);
        this.songName.setFont(FONT3);
        this.albumName.setFont(FONT2);
        this.artistName.setFont(FONT2);
        this.songName.setForeground(Color.WHITE);
        this.albumName.setForeground(Color.WHITE);
        this.artistName.setForeground(Color.WHITE);
        leftPanel.add(this.songName);
        leftPanel.add(this.albumName);
        leftPanel.add(this.artistName);
        this.songName.setBounds(10, 9, 140, 15);
        this.albumName.setBounds(10, 22, 140, 15);
        this.artistName.setBounds(10, 47, 140, 15);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBackground(MY_GRAY);

        JPanel controlPanel = new JPanel();
        centerPanel.add(controlPanel, BorderLayout.NORTH);
        controlPanel.setBackground(MY_GRAY);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        playPauseButton = new JButton();
        nextSongButton = new JButton();
        previousSongButton = new JButton();
        shuffleButton = new JButton();
        repeatButton = new JButton();
        controlPanel.add(repeatButton, FlowLayout.LEFT);
        controlPanel.add(nextSongButton, FlowLayout.LEFT);
        controlPanel.add(playPauseButton, FlowLayout.LEFT);
        controlPanel.add(previousSongButton, FlowLayout.LEFT);
        controlPanel.add(shuffleButton, FlowLayout.LEFT);
        playPauseButton.setPreferredSize(new Dimension(30, 30));
        playPauseButton.setBackground(MY_GRAY);
        playPauseButton.setBorderPainted(false);
        playPauseButton.setFocusPainted(false);
        playPauseButton.setBorder(new BevelBorder(BevelBorder.RAISED, MY_GRAY, MY_GRAY));
        if (!isPlaying)
            SwingUsefulMethods.JButtonSetIcon(this, playPauseButton, "ICON_SOURCE\\playi.png", 30, 30);
        else
            SwingUsefulMethods.JButtonSetIcon(this, playPauseButton, "ICON_SOURCE\\pausei.png", 30, 30);
        playPauseButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (seekBar.getValue() == seekBar.getMaximum()){
                    if (!isPlaying){
                        seekBar.setValue(0);
                        playSong(Manager.getNowPlayingSong().getFilePath());
                    }
                }
                if (!isPlaying) {
                    isPlaying = true;
                    options.resumeMusic();
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\pauseib.png", 30, 30);
                } else {
                    isPlaying = false;
                    options.pauseMusic();
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\playib.png", 30, 30);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isPlaying)
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\playib.png", 30, 30);
                else
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\pauseib.png", 30, 30);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (!isPlaying)
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\playi.png", 30, 30);
                else
                    SwingUsefulMethods.JButtonSetIcon(South.this, playPauseButton, "ICON_SOURCE\\pausei.png", 30, 30);
            }
        });
        shuffleButton.setPreferredSize(new Dimension(15, 15));
        shuffleButton.setBackground(MY_GRAY);
        shuffleButton.setBorderPainted(false);
        shuffleButton.setFocusPainted(false);
        shuffleButton.setBorder(new BevelBorder(BevelBorder.RAISED, MY_GRAY, MY_GRAY));
        SwingUsefulMethods.JButtonSetIcon(this, shuffleButton, "ICON_SOURCE\\shufflei.png", 15, 15);
        shuffleButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!isShuffle) {
                    isShuffle = true;
                    SwingUsefulMethods.JButtonSetIcon(South.this, shuffleButton, "ICON_SOURCE\\shuffleib.png", 15, 15);
                } else {
                    isShuffle = false;
                    SwingUsefulMethods.JButtonSetIcon(South.this, shuffleButton, "ICON_SOURCE\\shufflei.png", 15, 15);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isShuffle)
                    SwingUsefulMethods.JButtonSetIcon(South.this, shuffleButton, "ICON_SOURCE\\shuffleib.png", 15, 15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (!isShuffle)
                    SwingUsefulMethods.JButtonSetIcon(South.this, shuffleButton, "ICON_SOURCE\\shufflei.png", 15, 15);
            }
        });
        repeatButton.setPreferredSize(new Dimension(15, 15));
        repeatButton.setBackground(MY_GRAY);
        repeatButton.setBorderPainted(false);
        repeatButton.setFocusPainted(false);
        repeatButton.setBorder(new BevelBorder(BevelBorder.RAISED, MY_GRAY, MY_GRAY));
        SwingUsefulMethods.JButtonSetIcon(this, repeatButton, "ICON_SOURCE\\repeati.png", 15, 15);
        repeatButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!isRepeat) {
                    isRepeat = true;
                    SwingUsefulMethods.JButtonSetIcon(South.this, repeatButton, "ICON_SOURCE\\repeatib.png", 15, 15);
                } else {
                    isRepeat = false;
                    SwingUsefulMethods.JButtonSetIcon(South.this, repeatButton, "ICON_SOURCE\\repeati.png", 15, 15);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isRepeat)
                    SwingUsefulMethods.JButtonSetIcon(South.this, repeatButton, "ICON_SOURCE\\repeatib.png", 15, 15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (!isRepeat) {
                    SwingUsefulMethods.JButtonSetIcon(South.this, repeatButton, "ICON_SOURCE\\repeati.png", 15, 15);
                }
            }
        });
        nextSongButton.setPreferredSize(new Dimension(15, 15));
        nextSongButton.setBackground(MY_GRAY);
        nextSongButton.setBorderPainted(false);
        nextSongButton.setFocusPainted(false);
        nextSongButton.setBorder(new BevelBorder(BevelBorder.RAISED, MY_GRAY, MY_GRAY));
        SwingUsefulMethods.JButtonSetIcon(this, nextSongButton, "ICON_SOURCE\\nexti.png", 15, 15);
        nextSongButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SwingUsefulMethods.JButtonSetIcon(South.this, nextSongButton, "ICON_SOURCE\\nextib.png", 15, 15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SwingUsefulMethods.JButtonSetIcon(South.this, nextSongButton, "ICON_SOURCE\\nexti.png", 15, 15);
            }
        });
        previousSongButton.setPreferredSize(new Dimension(15, 15));
        previousSongButton.setBackground(MY_GRAY);
        previousSongButton.setBorderPainted(false);
        previousSongButton.setFocusPainted(false);
        previousSongButton.setBorder(new BevelBorder(BevelBorder.RAISED, MY_GRAY, MY_GRAY));
        SwingUsefulMethods.JButtonSetIcon(this, previousSongButton, "ICON_SOURCE\\previousi.png", 15, 15);
        previousSongButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                SwingUsefulMethods.JButtonSetIcon(South.this, previousSongButton, "ICON_SOURCE\\previousib.png", 15, 15);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                SwingUsefulMethods.JButtonSetIcon(South.this, previousSongButton, "ICON_SOURCE\\previousi.png", 15, 15);
            }
        });
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(100, 10));
        panel.setBackground(MY_GRAY);
        centerPanel.add(panel, BorderLayout.SOUTH);

        seekBar.setBorderPainted(false);
        seekBar.setBackground(new Color(70, 70, 70));
        centerPanel.add(seekBar, BorderLayout.CENTER);
        seekBar.setForeground(Color.WHITE);
        seekBar.setMaximum(Manager.getNowPlayingSong().getMp3File().getFrameCount() - 1);//new//fucking changed
        seekBar.setMinimum(0);//newly added
        seekBar.setValue(0);//newly added
        seekBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                double x = e.getX();
                double seekBarWidth = seekBar.getWidth();
                double result = x / seekBarWidth;
                double ans = result * Manager.getNowPlayingSong().getMp3File().getFrameCount();

                if (seekBar.getValue() == seekBar.getMaximum()){
                    super.mouseClicked(e);
                    playSong(Manager.getNowPlayingSong().getFilePath());
                    options.seek((int) ans);
                    seekBar.setValue((int) ans);
                }
                else {
                    super.mouseClicked(e);
                    options.seek((int) ans);
                    seekBar.setValue((int) ans);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });//newly added

        JPanel rightPanel = new JPanel();
        add(rightPanel, BorderLayout.EAST);
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setBackground(MY_GRAY);
        rightPanel.setPreferredSize(new Dimension(150, 70));
        volume = new JSlider(0, 100);
        volume.setUI(new CustomSliderUI(volume));
        volume.setBackground(MY_GRAY);
        volume.setFocusable(false);
        rightPanel.add(volume, BorderLayout.CENTER);
        setSystemVolume(20);//new
        volume.setValue(20);//new
        volume.addMouseListener(new MouseAdapter() {//new
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                double x = e.getX();
                if (x <= 0)
                    x = 0;
                if(x >= 110)
                    x = 110;
                double volumeWidth = volume.getWidth();
                double result = x / volumeWidth;
                double ans = result * 100;
                volume.setValue((int) ans);
                setSystemVolume((int) ans);
            }
        });

        JPanel empty1 = new JPanel();
        empty1.setBackground(MY_GRAY);
        empty1.setLayout(new ModifiedFlowLayout(ModifiedFlowLayout.RIGHT, 3, 0));
        listButton = new JButton();
        windowButton = new JButton();
        empty1.add(listButton, ModifiedFlowLayout.LEFT);
        empty1.add(windowButton, ModifiedFlowLayout.LEFT);
        windowButton.setPreferredSize(new Dimension(20, 20));
        windowButton.setBackground(MY_GRAY);
        windowButton.setBorderPainted(false);
        windowButton.setFocusPainted(false);
        windowButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (isListed) {
                    windowButton.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (isListed) {
                    isListed = false;
                    SwingUsefulMethods.JButtonSetIcon(South.this, listButton, "ICON_SOURCE\\listi.png", 20, 20);
                    listButton.setBackground(MY_GRAY);
                    SwingUsefulMethods.JButtonSetIcon(South.this, windowButton, "ICON_SOURCE\\windowib.png", 20, 20);
                    windowButton.setBackground(MY_GRAY);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (isListed) {
                    windowButton.setBackground(new Color(70, 70, 70));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                windowButton.setBackground(MY_GRAY);
            }
        });

        listButton.setPreferredSize(new Dimension(20, 20));
        listButton.setBackground(MY_GRAY);
        listButton.setBorderPainted(false);
        listButton.setFocusPainted(false);
        listButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!isListed) {
                    listButton.setBackground(Color.LIGHT_GRAY);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (!isListed) {
                    isListed = true;
                    SwingUsefulMethods.JButtonSetIcon(South.this, listButton, "ICON_SOURCE\\listib.png", 20, 20);
                    listButton.setBackground(MY_GRAY);
                    SwingUsefulMethods.JButtonSetIcon(South.this, windowButton, "ICON_SOURCE\\windowi.png", 20, 20);
                    windowButton.setBackground(MY_GRAY);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isListed) {
                    listButton.setBackground(new Color(70, 70, 70));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                listButton.setBackground(MY_GRAY);
            }
        });

        if (!isListed) {
            SwingUsefulMethods.JButtonSetIcon(this, listButton, "ICON_SOURCE\\listi.png", 20, 20);
            listButton.setBackground(MY_GRAY);
            SwingUsefulMethods.JButtonSetIcon(this, windowButton, "ICON_SOURCE\\windowib.png", 20, 20);
            windowButton.setBackground(MY_GRAY);
        } else {
            SwingUsefulMethods.JButtonSetIcon(this, listButton, "ICON_SOURCE\\listib.png", 20, 20);
            listButton.setBackground(MY_GRAY);
            SwingUsefulMethods.JButtonSetIcon(this, windowButton, "ICON_SOURCE\\windowi.png", 20, 20);
            windowButton.setBackground(MY_GRAY);
        }

        JPanel empty11 = new JPanel();
        empty11.setPreferredSize(new Dimension(32, 0));
        empty1.add(empty11, 2);
        JPanel empty12 = new JPanel();
        empty12.setBackground(MY_GRAY);
        empty12.setPreferredSize(new Dimension(5000, 10));
        empty1.add(empty12, 0);

        compactMode = new JButton();
        compactMode.setPreferredSize(new Dimension(20, 20));
        compactMode.setBackground(MY_GRAY);
        compactMode.setBorderPainted(false);
        compactMode.setFocusPainted(false);
        SwingUsefulMethods.JButtonSetIcon(this, compactMode, "ICON_SOURCE\\compacti.png", 20, 20);
        compactMode.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (!isCompact) {
                    isCompact = true;
                    SwingUsefulMethods.JButtonSetIcon(South.this, compactMode, "ICON_SOURCE\\compactib.png", 20, 20);
                    Manager.getMainFrame().setSize(600, 113);
                    Manager.getMainFrame().setResizable(false);
                } else {
                    isCompact = false;
                    SwingUsefulMethods.JButtonSetIcon(South.this, compactMode, "ICON_SOURCE\\compacti.png", 20, 20);
                    Manager.getMainFrame().setSize(800, 600);
                    Manager.getMainFrame().setResizable(true);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (!isCompact)
                    SwingUsefulMethods.JButtonSetIcon(South.this, compactMode, "ICON_SOURCE\\compactib.png", 20, 20);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (!isCompact) {
                    SwingUsefulMethods.JButtonSetIcon(South.this, compactMode, "ICON_SOURCE\\compacti.png", 20, 20);
                }
            }
        });
        empty1.add(compactMode, 4);
        JPanel empty13 = new JPanel();
        empty13.setPreferredSize(new Dimension(9, 0));
        empty1.add(empty13, 5);

        rightPanel.add(empty1, BorderLayout.NORTH);
        empty1.setPreferredSize(new Dimension(0, 40));
        JPanel empty2 = new JPanel();
        empty2.setBackground(MY_GRAY);
        rightPanel.add(empty2, BorderLayout.WEST);
        empty2.setPreferredSize(new Dimension(30, 0));
        JPanel empty3 = new JPanel();
        empty3.setBackground(MY_GRAY);
        rightPanel.add(empty3, BorderLayout.EAST);
        empty3.setPreferredSize(new Dimension(10, 0));

        timeElapsed = new MusicTime();
//        JLabel elapsed = new JLabel(timeElapsed.toString() + "  ");
        elapsed.setFont(FONT2);
        elapsed.setForeground(Color.WHITE);
        centerPanel.add(elapsed, BorderLayout.WEST);

        timeTotal = new MusicTime();//new
        timeTotal.setValue((int) Manager.getNowPlayingSong().getMp3File().getLengthInSeconds());//new
        JLabel total = new JLabel("  " + timeTotal.toString());
        total.setFont(FONT2);
        total.setForeground(Color.WHITE);
        centerPanel.add(total, BorderLayout.EAST);

        changeSong();
    }

    public void playSong(String address){
        options = new Options(address, seekBar);
        logicThread = new Thread(options);
        logicThread.start();
        Manager.setNowPlayingSong(new Song(address));
    }
    public void changeSong(){
        setAlbumName(Manager.getNowPlayingSong().getAlbumName());
        setArtistName(Manager.getNowPlayingSong().getArtistName());
        setSongName(Manager.getNowPlayingSong().getSongName());
    }

    public void setSongName(String songName) {
        if (songName != null)
            this.songName.setText(songName);
    }

    public void setAlbumName(String albumName) {
        if (albumName != null)
            this.albumName.setText(albumName);
    }

    public void setArtistName(String artistName) {
        if (artistName != null)
            this.artistName.setText(artistName);
    }

    public MusicTime getTimeElapsed() {
        return timeElapsed;
    }

    public void setSystemVolume(int volume) {
        if(volume < 0 || volume > 100)
        {
            throw new RuntimeException("Error: " + volume + " is not a valid number. Choose a number between 0 and 100");
        }

        else
        {
            double endVolume = 655.35 * volume;

            Runtime rt = Runtime.getRuntime();
            Process pr;
            try
            {
                pr = rt.exec("voice setting\\nircmd.exe" + " setsysvolume " + endVolume);
                pr = rt.exec("voice setting\\nircmd.exe" + " mutesysvolume 0");
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
