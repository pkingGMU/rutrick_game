package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JFrame;

public class WindowSettings {

    final private JFrame window;
    final private Container contentPane;
    final private Insets insets;

    public WindowSettings(String title, int width, int height) {

        //Initialize JFrame
        window = new JFrame(title);

       
        

        //Set basic properties
        
        //window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Insets to guarentee 800x600
        
        insets = window.getInsets();
        int frameWidth = width + insets.left + insets.right;
        int frameHeight = height + insets.top + insets.bottom;

        System.out.println("insets left");
        System.out.println(insets.left);

        System.out.println("frame width");
        System.out.println(frameWidth);

        window.getContentPane().setPreferredSize(new Dimension(width, height));
        window.pack();

        // Store content pane for further customization
        contentPane = window.getContentPane();

    }

    // Getters
    public JFrame getWindow() {
        return window;
    }

    public Container getContentPane() {
        return contentPane;
    }

    public void showWindow() {
        
        window.setVisible(true);
    }

        

    }
    
    

