package main;

import java.util.ArrayList;

public class PlayerDeck {

    
    private ArrayList<String[]> allCards;

    private String[] colorTypes;
    private String[] numberTypes;
    private String[] shapeTypes;
    private String[] fillTypes;

    public PlayerDeck() {

        this.colorTypes = new String[]{"Red", "Green", "Blue"};
        this.numberTypes = new String[]{"1", "2", "3"};
        this.shapeTypes = new String[]{"X", "Y", "Z"};
        this.fillTypes = new String[]{"No Fill", "Line Fill", "Fill"};

        this.allCards = generateDeck();

    }

    private ArrayList<String[]> generateDeck() {
        ArrayList<String[]> deck = new ArrayList<>();

        // Create all combinations of color, number, shape, and fill
        for (String color : colorTypes) {
            for (String number : numberTypes) {
                for (String shape : shapeTypes) {
                    for (String fill : fillTypes) {
                        // Each card is represented as an array of its properties
                        deck.add(new String[]{color, number, shape, fill});
                    }
                }
            }
        }

        return deck;
    }

    // Getters
    public int getTotalCardCount() {
        return allCards.size();
    }

    public ArrayList<String[]> getDeck() {
        return allCards;
    }

    // Methods
     // Draw a card from the deck (removes the card)
     public String[] drawCard() {
        if (!allCards.isEmpty()) {
            return allCards.remove(0); // Remove and return the first card
        }
        return null; // No cards left
    }

    // Add a card back to the deck
    public void addCard(String[] card) {
        allCards.add(card);
    }

    // Print the deck (for debugging)
    public void printDeck() {
        for (String[] card : allCards) {
            System.out.println(String.join(", ", card));
        }
    }




    
}
