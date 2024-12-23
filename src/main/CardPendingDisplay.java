package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CardPendingDisplay extends JPanel{

     public CardPendingDisplay(ArrayList<Card> cards, CreateObjectSpace pendingViewSpace, Main.GameActionListener aHandler) {

        pendingViewSpace.applyBounds(this);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setBackground(Color.orange);


        

        for (Card card : cards) {
            // Load the card image
            ImageIcon cardImage = new ImageIcon(card.getImagePath());

            // Create a mew button
            JButton cardButton = new JButton(cardImage);
            
            
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
            ImageIcon cardImage = new ImageIcon(card.getImagePath());
            JButton cardButton = new JButton(cardImage);
            cardButton.setBorder(BorderFactory.createEmptyBorder());
            cardButton.setContentAreaFilled(false);
            cardButton.setActionCommand(card.toString());
            
            this.add(cardButton);
        }
        this.revalidate(); // Refresh the layout
        this.repaint();
    }

    
}
