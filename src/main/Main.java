package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    GameActionListener aHandler = new GameActionListener();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    
        new Main();
        
        

    }

    public Main() {

        ui.createUI(aHandler);
        vm.showTitleScreen();
    }

    public class GameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //Action Event Handling logic

            String choice = event.getActionCommand();

            switch(choice){
                case "start": vm.showGamePlayArea();
            }

        }
    }

}
