package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class UI {

    // Create new JFrame
    WindowSettings settings;
    // Container
    Container con;
    // Title panel
    JPanel titleNamePanel;
    // JLabel for title
    JLabel titleNameLable;

    JPanel topMenuPanel;

    // Title Text Font
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);
    // Start button panel
    JPanel startButtonPanel;
    // Start button
    JButton startButton;
    // Normal Font
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    public void createUI(Main.GameActionListener aHandler) {



        // WINDOW // ----------------------------------------------------------------

        // Init JFrame using Window Settings
        settings = new WindowSettings("Game", 800, 600);
        
        // Show Frame
        settings.showWindow();

        // Access the content pane
        con = settings.getContentPane();


        String conDebug = String.format("Container Width: %d", con.getWidth());

        System.out.println(conDebug);

        // TITLE SCREEN // ----------------------------------------------------------------

        // Create new Title Text Panel
        CreateObjectSpace titleSpace = new CreateObjectSpace(con, 0.8, 0.25, 0.1, 0.1);
        titleNamePanel = new JPanel();
        titleSpace.applyBounds(titleNamePanel);
        titleNamePanel.setBackground(Color.black);

        // Use GridBagLayout for centering
        titleNamePanel.setLayout(new GridBagLayout());


        // Add Title text to title panel
        titleNameLable = new JLabel();
        titleNameLable.setText("Rutrick");
        titleNameLable.setForeground(Color.white);

        // Center contents
        //titleNameLable.setHorizontalAlignment(JLabel.CENTER);
        //titleNameLable.setVerticalAlignment(JLabel.CENTER);

        // Change title font
        titleNameLable.setFont(titleFont);

        // Add to panel
        titleNamePanel.add(titleNameLable);

        // Initial is invisible until we set it as visible
        titleNamePanel.setVisible(true);

        // Example: Creating and applying size and position for a JButton panel
        CreateObjectSpace buttonSpace = new CreateObjectSpace(con, .2, .09, .4, .5);
        startButtonPanel = new JPanel();
        buttonSpace.applyBounds(startButtonPanel);
        startButtonPanel.setBackground(Color.black);

        // Use GridBagLayout for centering
        startButtonPanel.setLayout(new GridBagLayout());


        // Start button
        startButton = new JButton("Start");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);

        // Button action handler
        startButton.addActionListener(aHandler);
        startButton.setActionCommand("start");


        // Add button to panel
        startButtonPanel.add(startButton);

        // Initial is invisible until we set it as visible
        startButtonPanel.setVisible(true);

        
    



        // Add to container
        con.add(titleNamePanel);
        con.add(startButtonPanel);



        // Gamplay area // ----------------------------------------------------------------

        // Dimensions for top menu
        CreateObjectSpace topMenuSpace = new CreateObjectSpace(con, 1, .15, 0, 0);

        // Panel for top menu
        topMenuPanel = new JPanel();
        topMenuSpace.applyBounds(topMenuPanel);
        topMenuPanel.setLayout(null); // Used this to manually position items
        topMenuPanel.setBackground(Color.gray);

        topMenuPanel.setVisible(false);

        con.add(topMenuPanel);



    }
    
}
