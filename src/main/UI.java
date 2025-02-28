package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
    // Top Menu
    JPanel topMenuPanel;

    JPanel topLeft;
    JLabel scoreTotalLabel;
    JLabel scoreTotalValueLabel;
    JLabel moneyTotalLabel;
    JLabel moneyTotalValueLabel;
    Font scoreTotalFont = new Font("Times New Roman", Font.PLAIN,20);

    JPanel topMiddle;
    JLabel gameTitelLabel;
    // Game Title Text Font
    Font gameTitleFont = new Font("Times New Roman", Font.PLAIN,70);

    JPanel topRight;
    JLabel handCounter;
    JLabel roundCounter;
    JLabel segmentCounter;
    Font counterFont = new Font("Times New Roman", Font.PLAIN,20);
    // Bottom Menu
    JPanel bottomMenuPanel;

    JPanel bottomLeft;
    JLabel potTotalLabel;
    JLabel potTotalValueLabel;
    JLabel potMoneyLabel;
    JLabel potMoneyValueLabel;
    Font potTotalFont = new Font("Times New Roman", Font.PLAIN,20);

    JPanel bottomMiddle;
    JButton viewDeckButton;
    JButton playHandButton;

    JPanel bottomRight;
    //GameplayPanel
    JPanel gameplayPanel;
    JButton testCard;

    JPanel playingAreaPanel;
    JPanel handViewPanel;

    JPanel deckViewPanel;

    JPanel shopViewPanel;

    // Title Text Font
    Font titleFont = new Font("Times New Roman", Font.PLAIN,90);
    // Start button panel
    JPanel startButtonPanel;
    // Start button
    JButton startButton;
    // Normal Font
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);

    
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
        titleNameLable.setText("SET");
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



        


        // TOP MENU // ----------------------------------------------------------------

        // Dimensions for top menu
        CreateObjectSpace topMenuSpace = new CreateObjectSpace(con, 1, .15, 0, 0);

        // Panel for top menu
        topMenuPanel = new JPanel();
        topMenuSpace.applyBounds(topMenuPanel);
        topMenuPanel.setLayout(null); // Used this to manually position items
        topMenuPanel.setBackground(Color.gray);
        topMenuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topMenuPanel.setVisible(false);

        // Top Left Panel
        // Dimensions
        CreateObjectSpace topLeftSpace = new CreateObjectSpace(topMenuPanel, .33, 1, 0, 0);
        topLeft = new JPanel();
        topLeftSpace.applyBounds(topLeft);
        topLeft.setBackground(Color.BLACK);
        topLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Use GridBagLayout for centering
        topLeft.setLayout(new GridBagLayout());

        // Text that will display Total Score: 
        scoreTotalLabel = new JLabel("TS:");
        scoreTotalLabel.setBackground(Color.black);
        scoreTotalLabel.setForeground(Color.white);
        scoreTotalLabel.setFont(scoreTotalFont);

        // Text that will display Total Score Value: 
        scoreTotalValueLabel = new JLabel("0");
        scoreTotalValueLabel.setBackground(Color.black);
        scoreTotalValueLabel.setForeground(Color.blue);
        scoreTotalValueLabel.setFont(scoreTotalFont);

        // Text that will display Money Score: 
        moneyTotalLabel = new JLabel("TM:");
        moneyTotalLabel.setBackground(Color.black);
        moneyTotalLabel.setForeground(Color.white);
        moneyTotalLabel.setFont(scoreTotalFont);

        // Text that will display Total Money Value: 
        moneyTotalValueLabel = new JLabel("0");
        moneyTotalValueLabel.setBackground(Color.black);
        moneyTotalValueLabel.setForeground(Color.lightGray);
        moneyTotalValueLabel.setFont(scoreTotalFont);

        topLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));
        
        topLeft.add(moneyTotalLabel);
        topLeft.add(moneyTotalValueLabel);
        topLeft.add(scoreTotalLabel);
        topLeft.add(scoreTotalValueLabel);
        topMenuPanel.add(topLeft);

        // Top Middle Panel
        // Dimensions
        CreateObjectSpace topMiddleSpace = new CreateObjectSpace(topMenuPanel, .34, 1, .33, 0);
        topMiddle = new JPanel();
        topMiddleSpace.applyBounds(topMiddle);
        topMiddle.setBackground(Color.BLACK);
        topMiddle.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        

        // Use GridBagLayout for centering
        topMiddle.setLayout(new GridBagLayout());

        // Text that will display SET
        gameTitelLabel = new JLabel("SET");
        gameTitelLabel.setBackground(Color.black);
        gameTitelLabel.setForeground(Color.white);
        gameTitelLabel.setFont(gameTitleFont);


        topMiddle.add(gameTitelLabel);
        topMenuPanel.add(topMiddle);

        // Top Right Panel
        // Dimensions
        CreateObjectSpace topRightSpace = new CreateObjectSpace(topMenuPanel, .33, 1, .67, 0);
        topRight = new JPanel();
        topRightSpace.applyBounds(topRight);
        topRight.setBackground(Color.BLACK);
        topRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        topRight.setLayout(new BoxLayout(topRight, BoxLayout.Y_AXIS));

        handCounter = new JLabel("Hand: 1");
        handCounter.setFont(counterFont);
        handCounter.setBackground(Color.black);
        handCounter.setForeground(Color.white);

        roundCounter = new JLabel("Round: 1");
        roundCounter.setFont(counterFont);
        roundCounter.setBackground(Color.black);
        roundCounter.setForeground(Color.white);

        segmentCounter = new JLabel("Segment: 1");
        segmentCounter.setFont(counterFont);
        segmentCounter.setBackground(Color.black);
        segmentCounter.setForeground(Color.white);

        
        topRight.add(handCounter);
        topRight.add(roundCounter);
        topRight.add(segmentCounter);
        topMenuPanel.add(topRight);
        


        con.add(topMenuPanel);

        // BOTTOM MENU // ----------------------------------------------------------------

        // Dimensions for bottom menu
        CreateObjectSpace bottomMenuSpace = new CreateObjectSpace(con, 1, .15, 0, .15);

        // Panel for bottom menu
        bottomMenuPanel = new JPanel();
        bottomMenuSpace.applyBounds(bottomMenuPanel);
        bottomMenuPanel.setLayout(null); // Used this to manually position items
        bottomMenuPanel.setBackground(Color.gray);
        bottomMenuPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        bottomMenuPanel.setVisible(false);

        con.add(bottomMenuPanel);

        // Bottom Left Panel
        // Dimensions
        CreateObjectSpace bottomLeftSpace = new CreateObjectSpace(bottomMenuPanel, .33, 1, 0, 0);
        bottomLeft = new JPanel();
        bottomLeftSpace.applyBounds(bottomLeft);
        bottomLeft.setBackground(Color.BLACK);
        bottomLeft.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Use GridBagLayout for centering
        bottomLeft.setLayout(new GridBagLayout());

        // Text that will display Total Score: 
        potTotalLabel = new JLabel("PS:");
        potTotalLabel.setBackground(Color.black);
        potTotalLabel.setForeground(Color.white);
        potTotalLabel.setFont(scoreTotalFont);

        // Text that will display Total Score Value: 
        potTotalValueLabel = new JLabel("0");
        potTotalValueLabel.setBackground(Color.black);
        potTotalValueLabel.setForeground(Color.white);
        potTotalValueLabel.setFont(scoreTotalFont);

        // Text that will display Money Score: 
        potMoneyLabel = new JLabel("PM:");
        potMoneyLabel.setBackground(Color.black);
        potMoneyLabel.setForeground(Color.white);
        potMoneyLabel.setFont(scoreTotalFont);

        // Text that will display Money Score Value: 
        potMoneyValueLabel = new JLabel("0");
        potMoneyValueLabel.setBackground(Color.black);
        potMoneyValueLabel.setForeground(Color.white);
        potMoneyValueLabel.setFont(scoreTotalFont);

        bottomLeft.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 40));

        
        bottomLeft.add(potMoneyLabel);
        bottomLeft.add(potMoneyValueLabel);
        bottomLeft.add(potTotalLabel);
        bottomLeft.add(potTotalValueLabel);
        bottomMenuPanel.add(bottomLeft);

        // Bottom Middle Panel
        // Dimensions
        CreateObjectSpace bottomMiddleSpace = new CreateObjectSpace(bottomMenuPanel, .34, 1, .33, 0);
        bottomMiddle = new JPanel();
        bottomMiddleSpace.applyBounds(bottomMiddle);
        bottomMiddle.setBackground(Color.BLACK);
        bottomMiddle.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // View deck button
        viewDeckButton = new JButton("View Deck");
        viewDeckButton.setBackground(Color.black);
        //viewDeckButton.setForeground(Color.white);
        viewDeckButton.setFont(normalFont);

        // Button action handler
        viewDeckButton.addActionListener(aHandler);
        viewDeckButton.setActionCommand("viewDeck");

        // Play hand button
        playHandButton = new JButton("Play Hand");
        playHandButton.setBackground(Color.black);
        //viewDeckButton.setForeground(Color.white);
        playHandButton.setFont(normalFont);

        // Button action handler
        playHandButton.addActionListener(aHandler);
        playHandButton.setActionCommand("playHand");

        
        bottomMiddle.add(viewDeckButton);
        bottomMiddle.add(playHandButton);
        bottomMenuPanel.add(bottomMiddle);

        // Bottom Right Panel
        // Dimensions
        CreateObjectSpace bottomRightSpace = new CreateObjectSpace(bottomMenuPanel, .33, 1, .67, 0);
        bottomRight = new JPanel();
        bottomRightSpace.applyBounds(bottomRight);
        bottomRight.setBackground(Color.black);
        bottomRight.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        bottomMenuPanel.add(bottomRight);


        // Gamplay area // ----------------------------------------------------------------

        // GAMEPLAY WINDOW // -------------------------------------------------------------
        // Dimensions for Gameplay Space
        CreateObjectSpace gameplaySpace = new CreateObjectSpace(con, 1, .7, 0, .3);

        // Panel for Gameplay Space
        gameplayPanel = new JPanel();
        gameplaySpace.applyBounds(gameplayPanel);
        gameplayPanel.setLayout(null); // Used this to manually position items
        gameplayPanel.setBackground(Color.gray);
        gameplayPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gameplayPanel.setVisible(false);


        con.add(gameplayPanel);

        // Playing Area
        // Dimensions
        CreateObjectSpace playingAreaSpace = new CreateObjectSpace(gameplayPanel, 1, .5, 0, 0);
        playingAreaPanel = new JPanel();
        playingAreaSpace.applyBounds(playingAreaPanel);
        playingAreaPanel.setBackground(Color.pink);
        playingAreaPanel.setBorder(BorderFactory.createLineBorder(Color.pink));
        playingAreaPanel.setVisible(false);

        gameplayPanel.add(playingAreaPanel);

        // Hand Area
        CreateObjectSpace handViewSpace = new CreateObjectSpace(gameplayPanel, 1, .5, 0, .5);
        handViewPanel = new JPanel();
        handViewSpace.applyBounds(handViewPanel);
        handViewPanel.setBackground(Color.lightGray);
        handViewPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
        handViewPanel.setVisible(false);
    
        gameplayPanel.add(handViewPanel);

        // View deck panel that replaces both playingarea and handview
        CreateObjectSpace deckViewSpace = new CreateObjectSpace(gameplayPanel, 1, 1, 0, 0);
        deckViewPanel = new JPanel();
        deckViewSpace.applyBounds(deckViewPanel);
        deckViewPanel.setBackground(Color.red);
        deckViewPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        deckViewPanel.setVisible(false);
        gameplayPanel.add(deckViewPanel);

        

        
    
}
    // Hand Area
    public void updateHandView(ArrayList<Card> playerHand, Main.GameActionListener aHandler) {
        if (handViewPanel != null) {
            gameplayPanel.remove(handViewPanel); // Remove the old panel
        }

        if (deckViewPanel != null) {
            gameplayPanel.remove(deckViewPanel); // Remove the old panel
        }

        //New way
        CreateObjectSpace handViewSpace = new CreateObjectSpace(gameplayPanel, 1, .5, 0, .5);
        handViewPanel = new CardDisplay(playerHand, handViewSpace, aHandler);

        // Add to the gameplay panel
        gameplayPanel.add(handViewPanel);
        gameplayPanel.revalidate();
        gameplayPanel.repaint();

    }

    public void updatePendingView(ArrayList<Card> pendingHand, Main.GameActionListener aHandler, String score, String money) {
        if (playingAreaPanel != null) {
            gameplayPanel.remove(playingAreaPanel); // Remove the old panel
        }

        if (deckViewPanel != null) {
            gameplayPanel.remove(deckViewPanel); // Remove the old panel
        }

        //New way
        CreateObjectSpace playingAreaSpace = new CreateObjectSpace(gameplayPanel, 1, .5, 0, 0);
        playingAreaPanel = new CardPendingDisplay(pendingHand, playingAreaSpace, aHandler);

        // Add to the gameplay panel
        gameplayPanel.add(playingAreaPanel);
        gameplayPanel.revalidate();
        gameplayPanel.repaint();

        // Change the potential score value
        if (potTotalValueLabel != null) {
            bottomLeft.remove(potTotalValueLabel);
            bottomLeft.remove(potMoneyValueLabel);
        }
        
        // Text that will display Total Score Value: 
        potTotalValueLabel = new JLabel(score);
        potTotalValueLabel.setBackground(Color.black);
        potTotalValueLabel.setForeground(Color.white);
        potTotalValueLabel.setFont(scoreTotalFont);

        // Text that will display Money Score Value: 
        potMoneyValueLabel = new JLabel(money);
        potMoneyValueLabel.setBackground(Color.black);
        potMoneyValueLabel.setForeground(Color.lightGray);
        potMoneyValueLabel.setFont(scoreTotalFont);

        

        
        bottomLeft.add(potMoneyLabel);
        bottomLeft.add(potMoneyValueLabel);
        bottomLeft.add(potTotalLabel);
        bottomLeft.add(potTotalValueLabel);
        bottomMenuPanel.add(bottomLeft);


        bottomMenuPanel.revalidate();
        bottomMenuPanel.repaint();
    }

    public void updateTotalScoreView (String score, String money) {
        if (scoreTotalValueLabel != null) {
            topLeft.remove(scoreTotalValueLabel);
            topLeft.remove(moneyTotalValueLabel);
        }

        if (deckViewPanel != null) {
            gameplayPanel.remove(deckViewPanel); // Remove the old panel
        }
        
        // Text that will display Total Score Value: 
        
        scoreTotalValueLabel = new JLabel(score);
        scoreTotalValueLabel.setBackground(Color.black);
        scoreTotalValueLabel.setForeground(Color.green);
        scoreTotalValueLabel.setFont(scoreTotalFont);

        // Text that will display Total Score Value: 
        moneyTotalValueLabel = new JLabel(money);
        moneyTotalValueLabel.setBackground(Color.black);
        moneyTotalValueLabel.setForeground(Color.lightGray);
        moneyTotalValueLabel.setFont(scoreTotalFont);

        topLeft.add(moneyTotalLabel);
        topLeft.add(moneyTotalValueLabel);
        topLeft.add(scoreTotalLabel);
        topLeft.add(scoreTotalValueLabel);
        topMenuPanel.add(topLeft);

        topMenuPanel.revalidate();
        topMenuPanel.repaint();
    }

    public void updateFullCardView (ArrayList<Card> fullDeck, Main.GameActionListener aHandler) {
        if (deckViewPanel != null) {
            gameplayPanel.remove(deckViewPanel); // Remove the old panel
        }

        //New way
        CreateObjectSpace deckViewSpace = new CreateObjectSpace(gameplayPanel, 1, 1, 0, 0);
        deckViewPanel = new CardFullDisplay(fullDeck, deckViewSpace, aHandler);

        // Add to the gameplay panel
        gameplayPanel.add(deckViewPanel);
        //gameplayPanel.revalidate();
        //gameplayPanel.repaint();
    }
    
    public void updateShopView (ArrayList<Card> shopDeck, Main.GameActionListener aHandler) {
        if (shopViewPanel != null) {
            gameplayPanel.remove(shopViewPanel); // Remove the old panel
        }

        // Create space
        CreateObjectSpace shopViewSpace = new CreateObjectSpace(gameplayPanel, 1, .9, 0, 0);
        shopViewPanel = new ShopDisplay(shopDeck, shopViewSpace, aHandler);

        

        gameplayPanel.add(shopViewPanel);
    }

    public void updatePlayHandButton(Main.GameActionListener aHandler) {
        if (playHandButton != null) {
            bottomMiddle.remove(playHandButton);
        }

        // Play hand button
        playHandButton = new JButton("End round");
        playHandButton.setBackground(Color.black);
        //viewDeckButton.setForeground(Color.white);
        playHandButton.setFont(normalFont);

        // Button action handler
        playHandButton.addActionListener(aHandler);
        playHandButton.setActionCommand("endRound");

        bottomMiddle.add(playHandButton);
        
        bottomMiddle.revalidate();
        bottomMiddle.repaint();
    }

    public void updateEndRoundButton(Main.GameActionListener aHandler) {
        if (playHandButton != null) {
            bottomMiddle.remove(playHandButton);
        }

        // Play hand button
        playHandButton = new JButton("Next round");
        playHandButton.setBackground(Color.black);
        //viewDeckButton.setForeground(Color.white);
        playHandButton.setFont(normalFont);

        // Button action handler
        playHandButton.addActionListener(aHandler);
        playHandButton.setActionCommand("nextRound");

        bottomMiddle.add(playHandButton);
        
        bottomMiddle.revalidate();
        bottomMiddle.repaint();
    }

    public void updateNextRoundButton(Main.GameActionListener aHandler) {
        if (playHandButton != null) {
            bottomMiddle.remove(playHandButton);
        }

        // Play hand button
        playHandButton = new JButton("Play Hand");
        playHandButton.setBackground(Color.black);
        //viewDeckButton.setForeground(Color.white);
        playHandButton.setFont(normalFont);

        // Button action handler
        playHandButton.addActionListener(aHandler);
        playHandButton.setActionCommand("playHand");

        bottomMiddle.add(playHandButton);
        
        bottomMiddle.revalidate();
        bottomMiddle.repaint();


    }

    public void updateCounters (Main.GameActionListener aHandler, int hand, int round, int segment) {
        if (handCounter != null) {
            topRight.remove(handCounter);
        } 

        if (roundCounter != null) {
            topRight.remove(roundCounter);
        } 

        if (segmentCounter != null) {
            topRight.remove(segmentCounter);
        } 

        handCounter = new JLabel("Hand: " + hand);
        handCounter.setFont(counterFont);
        handCounter.setBackground(Color.black);
        handCounter.setForeground(Color.white);

        roundCounter = new JLabel("Round: " + round);
        roundCounter.setFont(counterFont);
        roundCounter.setBackground(Color.black);
        roundCounter.setForeground(Color.white);

        segmentCounter = new JLabel("Segment: " + segment);
        segmentCounter.setFont(counterFont);
        segmentCounter.setBackground(Color.black);
        segmentCounter.setForeground(Color.white);

        
        topRight.add(handCounter);
        topRight.add(roundCounter);
        topRight.add(segmentCounter);

        topRight.repaint();
        topRight.revalidate();



    }


}
