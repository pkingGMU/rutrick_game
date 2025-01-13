package main;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerDeck {

    
    final private ArrayList<Card> deck;

    public PlayerDeck() {
        this.deck = new ArrayList<>();
        generateDeck();

    }

    private void generateDeck() {
        String[] colorTypes = {"Red", "Green", "Blue"};
        String[] numberTypes = {"1", "2", "3"};
        String[] shapeTypes = {"Circle", "Square", "Triangle"};
        String[] fillTypes = {"Solid", "Striped", "Empty"};

        // Create all combinations of color, number, shape, and fill
        for (String color : colorTypes) {
            for (String number : numberTypes) {
                for (String shape : shapeTypes) {
                   for (String fill : fillTypes) {
                        // Each card is by the Card Class
                        deck.add(new Card(color, number, shape, fill));
                    }
                }
            }
        }

        
        
        
        
        
        
        
        
        

        shuffleDeck();
        deleteDownToFirstHand();

    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void deleteDownToFirstHand() {

        System.out.println("Deck Size: " + deck.size());
        while (deck.size() > 6) {
            this.deck.remove(0);
        }
        System.out.println("Deck Size After reduction: " + deck.size());
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null; // No cards left
    }

    public void returnCardsFromDiscard(ArrayList<Card> discardCards) {
        for (Card card : discardCards) {
            this.deck.add(card);
        }
    }

    public void returnCardsFromHand(ArrayList<Card> handCards) {
        for (Card card : handCards) {
            this.deck.add(card);
        }
    }

    public void addCard(Card card) {
        this.deck.add(card);
    }

    public int getDeckSize() {
        return deck.size();
    }

    public void printDeck() {
        for (Card card : deck) {
            System.out.println(card);
        }
    }




    
}
