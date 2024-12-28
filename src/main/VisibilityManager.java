package main;

public class VisibilityManager {

    UI ui;

    public boolean viewDeckState = false;
    public boolean viewShopState = false;

    public VisibilityManager(UI userinterface) {

        ui = userinterface;

    }

    public void showTitleScreen() {
        // Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        if (ui.shopViewPanel != null) {
            // Disable the shop view
            ui.shopViewPanel.setVisible(false);
        }

        // Hide the game screen

        ui.con.revalidate();
        ui.con.repaint();

        //Update the viewDeckState
        viewDeckState = false;
        viewShopState = false;
        

    }

    public void showGamePlayArea() {
        // Disable the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Disable the full deck view
        ui.deckViewPanel.setVisible(false);

        if (ui.shopViewPanel != null) {
            // Disable the shop view
            ui.shopViewPanel.setVisible(false);
        }

        // Show the game screen
        ui.topMenuPanel.setVisible(true);
        ui.bottomMenuPanel.setVisible(true);
        ui.playingAreaPanel.setVisible(true);
        ui.handViewPanel.setVisible(true);
        ui.gameplayPanel.setVisible(true);

        ui.con.revalidate();
        ui.con.repaint();

        //Update the viewDeckState
        viewDeckState = false;
        viewShopState = false;
    }

    public void showFullDeck() {
        // Disable the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Hide the game screen
        ui.playingAreaPanel.setVisible(false);
        ui.handViewPanel.setVisible(false);
        
        if (ui.shopViewPanel != null) {
            // Disable the shop view
            ui.shopViewPanel.setVisible(false);
        }
        

        // Enable the deck view
        ui.deckViewPanel.setVisible(true);



        ui.con.revalidate();
        ui.con.repaint();

        //Update the viewDeckState
        viewDeckState = true;
        
    }

    public void showShopScreen() {

        // Disable the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        ui.playingAreaPanel.setVisible(false);
        ui.handViewPanel.setVisible(false);
        ui.deckViewPanel.setVisible(false);

        ui.shopViewPanel.setVisible(true);

        //Update the viewDeckState
        viewDeckState = false;
        viewShopState = true;
    }

    public void showEndScreen() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setDeckState(boolean state) {
        viewDeckState = state;
    }

    public void printDeckState() {
        System.out.println("Deck State: " + viewDeckState);
    }

    
    
}
