package main;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardButton extends JButton {
    private Card card;

    public CardButton(Card card) {
        super(new ImageIcon(card.getImagePath()));
        this.card = card;
    }

    public Card getCard() {
        return this.card;
    }
    
}
