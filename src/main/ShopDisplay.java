package main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ShopDisplay extends JPanel{

    public ShopDisplay(ArrayList<Card> cards, CreateObjectSpace deckViewSpace, Main.GameActionListener aHandler) {

        deckViewSpace.applyBounds(this);

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        this.setBackground(Color.white);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        

        for (Card card : cards) {
            

            // Create a mew button
            CardButton fullCardButton = new CardButton(card);
            
            fullCardButton.setText(card.getCardCostString());
            
            fullCardButton.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
            fullCardButton.setContentAreaFilled(false); // Make background transparent
            

            // Button action handler
            fullCardButton.addActionListener(aHandler);
            fullCardButton.setActionCommand("buyCard");
            
            

            this.add(fullCardButton);

            this.revalidate(); // Refresh the layout
            this.repaint();
        }

        

        



    }

    

    
}
