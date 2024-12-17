package main;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    // Create new JFrame
    JFrame window;
    // Container
    Container con;
    // Title panel
    JPanel titleNamePanel;
    // JLabel for title
    JLabel titleNameLable;
    // Title Text Font
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);
    // Start button panel
    JPanel startButtonPanel;
    // Start button
    JButton startButton;
    // Normal Font
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);




    public static void main(String[] args) {
        System.out.println("Hello, World!");
    

        new Main();
        

    }

    public Main() {

        // Init JFrame
        window = new JFrame();
        
        // Settings for window
        window.setTitle("Game Title!");
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.black);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        // Init container
        con = window.getContentPane();

        String conDebug = String.format("Container Width: %d", con.getWidth());

        System.out.println(conDebug);

        // Get container width and height to use for title size
        int titleWPadding = 100;
        int titleWidth = con.getWidth() - (titleWPadding * 2);

        int titleHeight = con.getHeight() / 4;

        System.out.println(titleWidth);
        System.out.println(titleHeight);

        // Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,100, titleWidth, titleHeight);
        titleNamePanel.setBackground(Color.black);

        // Add Title text to title panel
        titleNameLable = new JLabel();
        titleNameLable.setText("Rutrick");
        titleNameLable.setForeground(Color.white);

        // Change title font
        titleNameLable.setFont(titleFont);

        // Add to panel
        titleNamePanel.add(titleNameLable);

        // Get container width and height to use for title size
        int titleButtonWPadding = 300;
        int titleButtonWidth = con.getWidth() - (titleButtonWPadding * 2);

        int titleButtonHeight = con.getHeight() / 6;

        System.out.println(titleWidth);
        System.out.println(titleHeight);

        // Start button panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300,400,titleButtonWidth, titleButtonHeight);
        startButtonPanel.setBackground(Color.black);

        // Start button
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);

        // Add button to panel
        startButtonPanel.add(startButton);
        // Add to container
        con.add(titleNamePanel);
        con.add(startButtonPanel);

        

    }


    
}
