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
            CardButton pendingCardButton = new CardButton(card);
            
            
            pendingCardButton.setBorder(BorderFactory.createEmptyBorder()); // Remove button border
            pendingCardButton.setContentAreaFilled(false); // Make background transparent
            

            // Button action handler
            pendingCardButton.addActionListener(aHandler);
            pendingCardButton.setActionCommand("pendingCardClick");
            
            

            this.add(pendingCardButton);
        }

        



    }

    
}
