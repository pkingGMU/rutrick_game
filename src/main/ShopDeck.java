package main;

import java.util.ArrayList;
import java.util.Collections;

public class ShopDeck {

    final private ArrayList<Card> deck;

    public ShopDeck() {
        this.deck = new ArrayList<>();
        generateDeck();
    }

    public void generateDeck() {
        String[] colorTypes = {"Red", "Green", "Blue"};
        String[] numberTypes = {"1"};
        String[] shapeTypes = {"Square"};
        String[] fillTypes = {"Solid"};

        // Create all combinations of color, number, shape, and fill
        for (String color : colorTypes) {
           for (String number : numberTypes) {
                for (String shape : shapeTypes) {
                   for (String fill : fillTypes) {
                        // Each card is by the Card Class
                        this.deck.add(new Card(color, number, shape, fill));
                    }
                }
            }
        }

        shuffleDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public ArrayList<Card> createShop() {

        ArrayList<Card> shopCards = new ArrayList<>();

        for (int i = 0; i < 3 && i < this.deck.size(); i++)  {
            shopCards.add(deck.get(i));
        }

        return shopCards;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card drawCard() {
        if (!deck.isEmpty()) {
            return deck.remove(0);
        }
        return null; // No cards left
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
