package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class CardPendingDisplay extends JPanel{

     public CardPendingDisplay(ArrayList<Card> cards, CreateObjectSpace pendingViewSpace, Main.GameActionListener aHandler) {

        pendingViewSpace.applyBounds(this);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setBackground(Color.orange);


        

        for (Card card : cards) {
            

            // Create a mew button
            CardButton cardButton = new CardButton(card);
            
            
            cardButton.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
            cardButton.setContentAreaFilled(false); // Make background transparent
            

            // Button action handler
            cardButton.addActionListener(aHandler);
            cardButton.setActionCommand("pendingCardClick");
            
            

            this.add(cardButton);
        }

        



    }

    // Method to update the panel with new cards
    public void updateCards(ArrayList<Card> cards) {
        this.removeAll(); // Clear existing cards
        for (Card card : cards) {
            CardButton cardButton = new CardButton(card);
            cardButton.setBorder(BorderFactory.createEmptyBorder());
            cardButton.setContentAreaFilled(false);
            cardButton.setActionCommand(card.toString());
            
            this.add(cardButton);
        }
        this.revalidate(); // Refresh the layout
        this.repaint();
    }

    
}
