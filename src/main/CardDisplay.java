package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;





public class CardDisplay extends JPanel{
    
    public CardDisplay(ArrayList<Card> cards, CreateObjectSpace handViewSpace, Main.GameActionListener aHandler) {

        handViewSpace.applyBounds(this);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setBackground(Color.darkGray);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        

        for (Card card : cards) {


            // Create a mew button
            CardButton cardButton = new CardButton(card);
            
            
            cardButton.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
            cardButton.setContentAreaFilled(false); // Make background transparent
            

            // Button action handler
            cardButton.addActionListener(aHandler);
            cardButton.setActionCommand("handCardClick");
            
            

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
