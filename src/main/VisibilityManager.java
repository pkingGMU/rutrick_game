package main;

public class VisibilityManager {

    UI ui;

    public VisibilityManager(UI userinterface) {

        ui = userinterface;

    }

    public void showTitleScreen() {
        // Show the title screen
        ui.titleNamePanel.setVisible(true);
        ui.startButtonPanel.setVisible(true);

        // Hide the game screen

        ui.con.revalidate();
        ui.con.repaint();
        

    }

    public void showGamePlayArea() {
        // Disable the title screen
        ui.titleNamePanel.setVisible(false);
        ui.startButtonPanel.setVisible(false);

        // Show the game screen
        ui.topMenuPanel.setVisible(true);
        ui.bottomMenuPanel.setVisible(true);

        ui.con.revalidate();
        ui.con.repaint();
    }
    
}
