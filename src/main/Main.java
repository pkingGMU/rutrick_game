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
    PendingScoreManager pendingScoreManager = new PendingScoreManager();
    TotalScoreManager totalScoreManager = new TotalScoreManager();

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

        vm.printDeckState();
        
        ui.updateHandView(randomHand, aHandler);
        ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString());

        


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
                    vm.printDeckState();

                    if (pendingHand.getCurrentHandSize() >= 3) {
                        System.out.println("Hand is full");
                        break;
                        
                    }

                    Card clickedCard = null;

                    System.out.println("Clicked");
                    // Get the info of the card that was clicked
                    JButton sourceButton = (JButton) event.getSource();

                    if (sourceButton instanceof CardButton) {
                        // Cast to CardButton and get the associated Card
                        CardButton cardButton = (CardButton) sourceButton;
                        clickedCard = cardButton.getCard();
                        
                        // Now you can use the Card object for whatever you need
                        System.out.println("Card clicked: " + clickedCard);
                        
                        
                    }
                    
                    pendingHand.addCard(clickedCard);
                    pendingHand.printHand();

                    hand.removeCard(clickedCard);

                    pendingScoreManager.setCards(pendingHand.getHand());
                    pendingScoreManager.calculateScore();
                    System.out.println("Score: " + pendingScoreManager.getScoreString());

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString());
                    ui.updateFullCardView(deck.getDeck(), aHandler);

                    vm.printDeckState();

                    break;

                case "pendingCardClick":
                    vm.printDeckState();
                    System.out.println("Clicked");

                    Card clickedCard2 = null;


                    // Get the info of the card that was clicked
                    JButton sourceButton2 = (JButton) event.getSource();

                    if (sourceButton2 instanceof CardButton) {
                        // Cast to CardButton and get the associated Card
                        CardButton cardButton2 = (CardButton) sourceButton2;
                        clickedCard2 = cardButton2.getCard();
                        
                        // Now you can use the Card object for whatever you need
                        System.out.println("Card clicked: " + clickedCard2);
                        
                        
                    }
                    
                    pendingHand.removeCard(clickedCard2);
                    pendingHand.printHand();



                    hand.addCard(clickedCard2);

                    pendingScoreManager.setCards(pendingHand.getHand());
                    pendingScoreManager.calculateScore();
                    System.out.println("Score: " + pendingScoreManager.getScoreString());

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString());
                    ui.updateFullCardView(deck.getDeck(), aHandler);

                    
                    break;
                
                case "viewDeck":
                    if (!vm.viewDeckState) {
                        
                        System.out.println("View Deck");
                        vm.showFullDeck();
                        ui.updateFullCardView(deck.getDeck(), aHandler);
                        vm.printDeckState();



                        


                    } else {
                        
                        System.out.println("View Gameplay");
                        vm.showGamePlayArea();
                        ui.updateFullCardView(deck.getDeck(), aHandler);
                        vm.printDeckState();

                        
                    }
                    break;

                case "playHand":
                    if (pendingHand.getCurrentHandSize() == 3) {
                        System.out.println("Play Hand");
                        totalScoreManager.updateTotalScore(pendingScoreManager.getScoreInt());
                        totalScoreManager.printTotalScore();

                        pendingHand.clearHand();
                        pendingScoreManager.setCards(pendingHand.getHand());
                        pendingScoreManager.calculateScore();

                        hand.drawCard(deck);
                        hand.drawCard(deck);
                        hand.drawCard(deck);

                        ui.updateHandView(randomHand, aHandler);
                        ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString());
                        ui.updateFullCardView(deck.getDeck(), aHandler);



                        ui.updateTotalScoreView(totalScoreManager.getTotalScoreString());
                        
                        
                    } else {
                        System.out.println("Hand is not full");
                    }
                    break;

                    

                    
                    
                    


            }

        }
    }

}
