package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {

    GameActionListener aHandler = new GameActionListener();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    PlayerDeck deck;
    PlayerHand hand;
    ArrayList<Card> randomHand;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    
        new Main();
        
        

    }

    public Main() {

        ui.createUI(aHandler);
        vm.showTitleScreen();

        deck = new PlayerDeck();
        hand = new PlayerHand();

        randomHand = hand.createRandomHand(deck);

        hand.printHand();
        
        ui.updateHandView(randomHand, aHandler);

        for (Card card : randomHand) {
            card.getImageIcon();
            
        }

    }

    public class GameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //Action Event Handling logic

            String choice = event.getActionCommand();

            switch(choice){
                case "start": 
                    vm.showGamePlayArea();
                    break;
                case "cardClick": 
                    System.out.println("Clicked");
                    randomHand = hand.drawCard(deck);
                    ui.updateHandView(randomHand, aHandler);
                    break;

            }

        }
    }

}
