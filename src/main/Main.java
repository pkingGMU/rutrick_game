package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class Main {

    GameActionListener aHandler = new GameActionListener();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    PlayerDeck deck;
    PlayerHand hand;
    PendingHand pendingHand;
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
        pendingHand = new PendingHand();

        randomHand = hand.createRandomHand(deck);

        hand.printHand();
        
        ui.updateHandView(randomHand, aHandler);
        ui.updatePendingView(pendingHand.getHand(), aHandler);


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
                case "handCardClick": 
                    System.out.println("Clicked");
                    // Get the info of the card that was clicked
                    String cardInfo = ((JButton) event.getSource()).getIcon().toString();
                    
                    pendingHand.addCard(cardInfo);
                    pendingHand.printHand();

                    hand.removeCard(cardInfo);

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler);
                    break;

                case "pendingCardClick":
                    System.out.println("Clicked");
                    // Get the info of the card that was clicked
                    String cardInfo2 = ((JButton) event.getSource()).getIcon().toString();
                    
                    pendingHand.removeCard(cardInfo2);
                    pendingHand.printHand();

                    hand.addCard(cardInfo2);

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler);
                    break;

            }

        }
    }

}
