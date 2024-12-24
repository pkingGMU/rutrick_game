package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class PendingHand {
    private ArrayList<Card> hand;
    private int handSize;
    

    public PendingHand() {
        this.handSize = 3;
        this.hand = new ArrayList<>();


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


            System.err.println("\n\n\n");
            System.out.println(String.join(", ", card.toString()));
        }
    }

    // Set hand size
    public void setHandSize(int newSize) {
        this.handSize = newSize;
    }

    public int getHandSize() {
        return handSize;
    }

    public int getCurrentHandSize() {
        return hand.size();
    }
    
    
}
