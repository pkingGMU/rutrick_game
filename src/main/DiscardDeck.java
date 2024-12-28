package main;

import java.util.ArrayList;

public class DiscardDeck extends PlayerDeck {

    private ArrayList<Card> discardDeck;

    public DiscardDeck() {
        super();
        this.discardDeck  = new ArrayList<>();
    }

    public void addCardsToDiscardDeck(ArrayList<Card> cards) {
        discardDeck.addAll(cards);
    }

    public ArrayList<Card> getDiscardDeck() {
        return discardDeck;
    }

    public void removeAllCardsFromDiscardDeck() {
        discardDeck.clear();
    }
    
}
