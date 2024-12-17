package main;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;

public class WindowSettings {

    private JFrame window;
    private Container contentPane;

    public WindowSettings(String title, int width, int height) {

        //Initialize JFrame
        window = new JFrame(title);

        //Set basic properties
        
        window.setSize(width, height);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        window.setResizable(false);
        window.getContentPane().setBackground(Color.BLACK);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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
    
    
}
