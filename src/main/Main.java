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
    ShopDeck shopDeck;
    PlayerHand hand;
    PendingHand pendingHand;
    DiscardDeck discardDeck;
    ArrayList<Card> randomHand;
    ArrayList<Card> shopHand;
    PendingScoreManager pendingScoreManager;
    TotalScoreManager totalScoreManager = new TotalScoreManager();
    RoundManager roundManager = new RoundManager();

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    
        new Main();
        
        

    }

    public Main() {

        ui.createUI(aHandler);
        vm.showTitleScreen();

        deck = new PlayerDeck();
        shopDeck = new ShopDeck();
        hand = new PlayerHand();
        pendingHand = new PendingHand();
        discardDeck = new DiscardDeck();
        pendingScoreManager = new PendingScoreManager(pendingHand.getHand());

        randomHand = hand.createRandomHand(deck);

        shopHand = shopDeck.createShop();

        roundManager.printRound();
        
        ui.updateHandView(randomHand, aHandler);
        ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());

        ui.deckViewPanel.setVisible(false);

        


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
                    pendingScoreManager.calculateMoney();
                    System.out.println("Score: " + pendingScoreManager.getScoreString());

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());
                    

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
                    pendingScoreManager.calculateMoney();
                    System.out.println("Score: " + pendingScoreManager.getScoreString());

                    
                    ui.updateHandView(randomHand, aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());
                   


                    
                    break;
                
                case "viewDeck":
                    if (!vm.viewDeckState) {
                        
                        System.out.println("View Deck");
                        vm.showFullDeck();
                        ui.updateFullCardView(deck.getDeck(), aHandler);
                        vm.printDeckState();

                    } else if (!vm.viewShopState) {
                        
                        System.out.println("View Gameplay");
                        vm.showGamePlayArea();
                        
                        vm.printDeckState();
                    } else {
                        System.out.println("View Shop");
                        vm.showShopScreen();
                        
                    }
                    break;

                case "playHand":
                    if (pendingHand.getCurrentHandSize() == 3) {
                        System.out.println("Play Hand");
                        totalScoreManager.updateTotalScore(pendingScoreManager.getScoreInt());
                        totalScoreManager.printTotalScore();

                        totalScoreManager.updateTotalMoney(pendingScoreManager.getMoneyInt());
                        totalScoreManager.printTotalMoney();

                        discardDeck.addCardsToDiscardDeck(pendingHand.getHand());

                        pendingHand.clearHand();
                        pendingScoreManager.setCards(pendingHand.getHand());
                        pendingScoreManager.calculateScore();
                        pendingScoreManager.calculateMoney();


                        // Update round
                        if (roundManager.isEndRound() && roundManager.isEndStage()) {
                            ui.updatePlayHandButton(aHandler);
                            
                        } else if (roundManager.isEndStage()) {
                            roundManager.nextRound();
                            roundManager.printRound();
                            roundManager.resetStage();

                            deck.returnCardsFromDiscard(discardDeck.getDeck());
                            discardDeck.removeAllCardsFromDiscardDeck();
                        } else {
                            roundManager.nextStage();
                        }

                        
                        if (deck.getDeck().size() >= 3) {
                            hand.drawCard(deck);
                            hand.drawCard(deck);
                            hand.drawCard(deck);
                        } else if (deck.getDeck().size() == 2) {
                            hand.drawCard(deck);
                            hand.drawCard(deck);
                        } else if (deck.getDeck().size() == 1) {
                            hand.drawCard(deck);
                        }

                        ui.updateHandView(randomHand, aHandler);
                        ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());

                        ui.updateTotalScoreView(totalScoreManager.getTotalScoreString(), totalScoreManager.getTotalMoneyString());
                        
                        
                        
                        
                    } else {
                        System.out.println("Hand is not full");
                    }

                    

                    break;

                case "endRound":
                    ui.updateShopView(shopHand, aHandler);
                
                    vm.showShopScreen();

                    ui.updateEndRoundButton(aHandler);
                    
                    break;
                
                case "nextRound":
                    
                
                case "buyCard":
                    System.out.println("Buy Card");
                    break;

                    

                    
                    
                    


            }

        }
    }

}
