package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");



        // Create new JFrame
        JFrame window = new JFrame();
        window.setTitle("Game Title!");
        window.setSize(800, 600);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

// EXAMPLE WRITE TEXT TO SCREEN USING LABEL //
        // Create a test label
        JLabel test_label = new JLabel();
        JLabel test_text2 = new JLabel();

        // Set text for label
        test_label.setText("HELLOOOOO :#");
        test_text2.setText("This is our other text for our other label");

        // Change font size
        test_label.setFont(new Font("Calibri", Font.BOLD, 50));
        test_text2.setFont(new Font("Calibri", Font.BOLD, 30));

        // Creatomg test panel for the text
        JPanel test_text_panel = new JPanel();
        // Add label to the panel
        test_text_panel.add(test_label);
        test_text_panel.add(test_text2);

        // EXAMPLE BUTTON TO SCREEN USING PANEL //
        // Create button
        JPanel test_button_panel = new JPanel();
        JButton test_button = new JButton("Click me");

        // Add button to button panel
        test_button_panel.add(test_button);

        // Set layout for the main window frame
        window.setLayout(new BorderLayout());

        // Add button panel to frame
        window.add(test_button_panel, BorderLayout.PAGE_START);
        window.add(test_text_panel);

    }


    
}
