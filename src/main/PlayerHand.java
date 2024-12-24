package main;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerHand {

    private ArrayList<Card> hand;
    private int handSize;
    

    public PlayerHand() {
        this.handSize = 5;
        this.hand = new ArrayList<>();


    }

    public ArrayList<Card> createRandomHand(PlayerDeck deck) {
        
        hand.clear();

        Collections.shuffle(deck.getDeck());

        for (int i = 0; i < handSize && deck.getDeckSize() > 0; i++) {
            hand.add(deck.drawCard());
        }

        return hand;

    }

    public ArrayList<Card> drawCard(PlayerDeck deck) {
        hand.add(deck.drawCard());
        return hand;
    }

    public ArrayList<Card> addCard(Card card) {

        if (hand.size() >= handSize) {
            return hand;
        }
        hand.add(card);
        return hand;
        
    }

    public ArrayList<Card> removeCard(Card card) {
        if (hand.size() <=0) {
            return hand;
        }
        hand.remove(card);
        return hand;
    }

    // Get the current hand
    public ArrayList<Card> getHand() {
        return hand;
    }

    // Display hand (for debugging)
    public void printHand() {
        for (Card card : hand) {



            System.out.println(String.join(", ", card.toString()));
        }
    }

    // Set hand size
    public void setHandSize(int newSize) {
        this.handSize = newSize;
    }
    
}
