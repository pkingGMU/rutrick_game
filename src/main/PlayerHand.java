package main;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerHand {

    private int handSize;
    private ArrayList<String[]> hand;

    public PlayerHand() {
        this.handSize = 4;
        this.hand = new ArrayList<>();

    }

    public ArrayList<String[]> createRandomHand(PlayerDeck deck) {
        hand.clear();

        Collections.shuffle(deck.getDeck());

        for (int i = 0; i < handSize && deck.getTotalCardCount() > 0; i++) {
            hand.add(deck.drawCard());
        }

        return hand;

    }

    // Get the current hand
    public ArrayList<String[]> getHand() {
        return hand;
    }

    // Display hand (for debugging)
    public void printHand() {
        for (String[] card : hand) {
            System.out.println(String.join(", ", card));
        }
    }

    // Set hand size
    public void setHandSize(int newSize) {
        this.handSize = newSize;
    }
    
}
