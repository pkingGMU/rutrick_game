package main;

import java.util.ArrayList;

public class DiscardDeck {

    private ArrayList<Card> discardDeck;

    public DiscardDeck() {
        this.discardDeck  = new ArrayList<>();
    }

    public void addCardsToDiscardDeck(ArrayList<Card> cards) {
        discardDeck.addAll(cards);
    }

    public ArrayList<Card> getDiscardDeck() {
        return this.discardDeck;
    }

    public void removeAllCardsFromDiscardDeck() {
        this.discardDeck.clear();
    }

    public void printDeck() {
        System.out.println(this.getDiscardDeck());
    }
    
}
