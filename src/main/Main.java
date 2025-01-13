package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

public class Main {

    GameActionListener aHandler = new GameActionListener();
    UI ui = new UI();
    VisibilityManager vm;
    PlayerDeck deck;
    ShopDeck shopDeck;
    PlayerHand hand;
    PendingHand pendingHand;
    DiscardDeck discardDeck;
    
    ArrayList<Card> shopHand;
    PendingScoreManager pendingScoreManager;
    TotalScoreManager totalScoreManager;
    RoundManager roundManager;

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    
        new Main();
        
        

    }

    public Main() {

        vm = new VisibilityManager(ui);
        ui.createUI(aHandler);
        vm.showTitleScreen();
    }

    public class GameActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            //Action Event Handling logic

            String choice = event.getActionCommand();

            switch(choice){
                case "start": 
                    vm.showGamePlayArea();

                    // Create deck
                    deck = new PlayerDeck();

                    // Create new shop deck
                    shopDeck = new ShopDeck();

                    // Create new player hand
                    hand = new PlayerHand(deck);

                    // Create new pending hand
                    pendingHand = new PendingHand();

                    // Create new discard deck
                    discardDeck = new DiscardDeck();

                    // Create new pending score manager
                    pendingScoreManager = new PendingScoreManager(pendingHand.getHand());

                    totalScoreManager = new TotalScoreManager();

                    roundManager = new RoundManager();

                    shopHand = shopDeck.createShop();

                    roundManager.printRound();

                    // Update hand, round, and segment counters

                    ui.updateCounters(aHandler, roundManager.getStage(), roundManager.getRound(), roundManager.getSegment());
                    ui.updateTotalScoreView(totalScoreManager.getTotalScoreString(), totalScoreManager.getTotalMoneyString());
                    ui.updateTotalScoreView("0", "0");
                    ui.updateHandView(hand.getHand(), aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());

                    ui.deckViewPanel.setVisible(false);

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

                    
                    ui.updateHandView(hand.getHand(), aHandler);
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

                    
                    ui.updateHandView(hand.getHand(), aHandler);
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
                            break;
                            
                        } else if (roundManager.isEndStage()) {
                            roundManager.nextRound();
                            roundManager.printRound();
                            roundManager.resetStage();
                            roundManager.printStage();

                            deck.returnCardsFromDiscard(discardDeck.getDiscardDeck());
                            discardDeck.removeAllCardsFromDiscardDeck();
                        } else {
                            roundManager.nextStage();
                            roundManager.printStage();
                        }

                        int cardsToBeDrawn = 0;
                        
                        if (deck.getDeck().size() >= 3 && roundManager.getStage() == 1 && roundManager.getRound() != 1) {
                            cardsToBeDrawn =  hand.getHandSize() - hand.getHand().size();
                        } else if (deck.getDeck().size() >= 3) {
                            cardsToBeDrawn = hand.getHandSize() - hand.getHand().size();
                        } else if (deck.getDeck().size() == 2) {
                            cardsToBeDrawn = hand.getHandSize() - hand.getHand().size() - 1;
                        } else if (deck.getDeck().size() == 1) {
                            cardsToBeDrawn = 1;
                        }

                        for (int i = 0; i < cardsToBeDrawn; i++) {
                            hand.drawCard(deck);
                        }

                        ui.updateHandView(hand.getHand(), aHandler);
                        ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());

                        ui.updateTotalScoreView(totalScoreManager.getTotalScoreString(), totalScoreManager.getTotalMoneyString());
                        
                        
                        
                        
                    } else {
                        System.out.println("Hand is not full");
                    }

                    // Update hand, round, and segment counters

                    ui.updateCounters(aHandler, roundManager.getStage(), roundManager.getRound(), roundManager.getSegment());

                    

                    break;

                case "endRound":

                    deck.returnCardsFromDiscard(discardDeck.getDiscardDeck());
                    discardDeck.removeAllCardsFromDiscardDeck();

                    System.err.println("DISCARD DECK AFTER END ROUND");
                    discardDeck.printDeck();

                    deck.returnCardsFromHand(hand.getHand());
                    hand.removeAllCards();

                    pendingScoreManager.resetAll();
                    pendingHand.clearHand();
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());


                    if (roundManager.isEndSegment()) {

                        deck = null;

                        roundManager.resetStage();
                        roundManager.resetRound();
                        roundManager.resetSegment();

                        

                        

                        shopHand = null;

                        
                        ui.updateNextRoundButton(aHandler);

                        System.gc();

                        vm.showTitleScreen();
                        break;
                    }

                    ui.updateShopView(shopHand, aHandler);
                
                    vm.showShopScreen();

                    ui.updateEndRoundButton(aHandler);
                    
                    
                    break;
                
                case "nextRound":

                    if (roundManager.isEndSegment()) {
                        System.out.println("Game over");
                        break;
                    }

                    

                    System.err.println("DISCARD DECK AFTER NEXT ROUND");

                    discardDeck.removeAllCardsFromDiscardDeck();
                    
                    discardDeck.printDeck();

                    int cardsToBeDrawn = hand.getHandSize();

                    for (int i = 0; i < cardsToBeDrawn; i++) {
                        hand.drawCard(deck);
                    }

                    roundManager.resetRound();
                    roundManager.resetStage();
                    roundManager.nextSegment();

                    ui.updateCounters(aHandler, roundManager.getStage(), roundManager.getRound(), roundManager.getSegment());

                    vm.showGamePlayArea();

                    
                    ui.updateNextRoundButton(aHandler);
                    ui.updateHandView(hand.getHand(), aHandler);
                    ui.updatePendingView(pendingHand.getHand(), aHandler, pendingScoreManager.getScoreString(), pendingScoreManager.getMoneyString());



                    ui.deckViewPanel.setVisible(false);

                    break;
                
                case "buyCard":
                    System.out.println("Buy Card");
                    Card clickedCard3 = null;

                    


                    // Get the info of the card that was clicked
                    JButton sourceButton3 = (JButton) event.getSource();

                    if (sourceButton3 instanceof CardButton) {
                        // Cast to CardButton and get the associated Card
                        CardButton cardButton3 = (CardButton) sourceButton3;
                        clickedCard3 = cardButton3.getCard();
                        
                        // Now you can use the Card object for whatever you need
                        System.out.println("Card clicked: " + clickedCard3);
                        
                        
                    }
                    
                    if (clickedCard3.getCardCost() > totalScoreManager.getTotalMoney()) {
                        break;
                    }
                    
                    deck.addCard(clickedCard3);
                    totalScoreManager.subtractMoney(clickedCard3.getCardCost());
                    ui.updateTotalScoreView(totalScoreManager.getTotalScoreString(), totalScoreManager.getTotalMoneyString());


                    break;

                    

                    
                    
                    


            }

        }
    }

}
