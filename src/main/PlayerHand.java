package main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class PlayerHand {

    private ArrayList<Card> hand;
    private int handSize;
    

    public PlayerHand() {
        this.handSize = 2;
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

    public ArrayList<Card> addCard(String pathString) {

        if (hand.size() >= handSize) {
            return hand;
        }

        Path path = Paths.get(pathString);
        String fileName = path.getFileName().toString();

        // Remove the file extension
        String[] parts = fileName.split("\\.");
        String cardName = parts[0];
        // Split the card name into its parts
        String[] cardParts = cardName.split("_");

        

        hand.add(new Card(cardParts[0], cardParts[1], cardParts[2], cardParts[3]));
        return hand;
        
    }

    public ArrayList<Card> removeCard(String pathString) {
        if (hand.size() <= 0) {
            return hand;
        }

        Path path = Paths.get(pathString);
        String fileName = path.getFileName().toString();

        // Remove the file extension
        String[] parts = fileName.split("\\.");
        String cardName = parts[0];
        // Split the card name into its parts
        String[] cardParts = cardName.split("_");

        

        hand.remove(new Card(cardParts[0], cardParts[1], cardParts[2], cardParts[3]));
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
