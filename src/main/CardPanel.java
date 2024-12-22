package main;

import java.awt.Container;

import javax.swing.JPanel;


public class CardPanel extends JPanel{
    
    private int cardSize;

    // Constructor
    public CardPanel(Container con) {
        this.cardSize = con.getWidth();
    }

    // Getter for cardSize
    public int getCardSize() {
        return cardSize;
    }


}
