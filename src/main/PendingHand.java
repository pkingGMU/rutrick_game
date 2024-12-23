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
        if (hand.size() <=0) {
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


            System.err.println("\n\n\n");
            System.out.println(String.join(", ", card.toString()));
        }
    }

    // Set hand size
    public void setHandSize(int newSize) {
        this.handSize = newSize;
    }
    
    
}
