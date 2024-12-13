package main;

import javax.swing.JFrame;

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

    }


    
}
