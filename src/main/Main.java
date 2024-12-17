package main;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Main {

    // Create new JFrame
    WindowSettings settings;
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

        // Init JFrame using Window Settings
        settings = new WindowSettings("Game", 800, 600);
        
        // Show Frame
        settings.showWindow();

        // Access the content pane
        con = settings.getContentPane();


        String conDebug = String.format("Container Width: %d", con.getWidth());

        System.out.println(conDebug);

        // Calculate title size and position dynamically
        Map<String, Double> sizeAndPosition = getTitleSizeandPosition(con, 0.8, .25, .1, .1);

        int titleWidth = (int)Math.round(sizeAndPosition.get("width"));
        int titleHeight = (int)Math.round(sizeAndPosition.get("height"));
        int titleStartingPosX = (int)Math.round(sizeAndPosition.get("startingPosX"));
        int titleStartingPosY = (int)Math.round(sizeAndPosition.get("startingPosY"));

        System.out.println(titleStartingPosX);
        System.out.println(titleStartingPosY);

        // Title Screen
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(titleStartingPosX,titleStartingPosY, titleWidth, titleHeight);
        titleNamePanel.setBackground(Color.black);

        // Add Title text to title panel
        titleNameLable = new JLabel();
        titleNameLable.setText("Rutrick");
        titleNameLable.setForeground(Color.white);

        // Change title font
        titleNameLable.setFont(titleFont);

        // Add to panel
        titleNamePanel.add(titleNameLable);

        // Calculate button size and position dynamically
        Map<String, Double> buttonSizeAndPosition = getTitleSizeandPosition(con, .2, .09, .4, .5);

        int titleButtonWidth = (int)Math.round(buttonSizeAndPosition.get("width"));
        int titleButtonHeight = (int)Math.round(buttonSizeAndPosition.get("height"));
        int titleButtonStartingPosX = (int)Math.round(buttonSizeAndPosition.get("startingPosX"));
        int titleButtonStartingPosY = (int)Math.round(buttonSizeAndPosition.get("startingPosY"));

        System.out.println("Title Button");
        System.out.println(titleButtonWidth);
        System.out.println(titleButtonHeight);

        // Start button panel
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(titleButtonStartingPosX,titleButtonStartingPosY,titleButtonWidth, titleButtonHeight);
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

        con.revalidate();
        con.repaint();

        

    }

    public Map<String, Double> getTitleSizeandPosition (Container con, double widthFactor, double heightFactor, double startingPosXFactor, double startingPosYFactor) {

        
        double width = con.getWidth() * widthFactor;
        double height = con.getHeight() * heightFactor;
        double startingPosX = con.getWidth() * startingPosXFactor;
        double startingPosY = con.getHeight() * startingPosYFactor;

        // Create and populate the map
        Map<String, Double> sizeAndPositionMap = new HashMap<>();
        
        sizeAndPositionMap.put("width", width);
        sizeAndPositionMap.put("height", height);
        sizeAndPositionMap.put("startingPosX", startingPosX);
        sizeAndPositionMap.put("startingPosY", startingPosY);

        return sizeAndPositionMap;

    }


    
}
