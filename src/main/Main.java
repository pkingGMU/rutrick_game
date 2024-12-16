package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
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

    // Font
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);

    // Create Label Objects
    JLabel test_label;
    JLabel test_text2;
    // Create test panel for the text
    JPanel test_text_panel;

    // Create button
    JPanel test_button_panel = new JPanel();
    JButton test_button = new JButton("Click me");


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

        // Add to container
        con.add(titleNamePanel);

        

    }


    
}
