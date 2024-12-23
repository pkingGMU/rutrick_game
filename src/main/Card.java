package main;

import java.util.Objects;
import javax.swing.ImageIcon;

public class Card {

    private String color;
    private String number;
    private String shape;
    private String fill;

    public Card(String color, String number, String shape, String fill) {
        this.color = color;
        this.number = number;
        this.shape = shape;
        this.fill = fill;
    }

    // Getters
    public String getColor() {
        return color;
    }

    public String getNumber() {
        return number;
    }

    public String getShape() {
        return shape;
    }

    public String getFill() {
        return fill;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s", color, number, shape, fill);
    }

    // Override equals to compare cards by their properties
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return Objects.equals(color, card.color) &&
               Objects.equals(number, card.number) &&
               Objects.equals(shape, card.shape) &&
               Objects.equals(fill, card.fill);
    }

    // Override hashCode to maintain consistency with equals
    @Override
    public int hashCode() {
        return Objects.hash(color, number, shape, fill);
    }

    public ImageIcon getImageIcon() {
        String imagePath = getImagePath();
        
        if (imagePath == null) {
            System.err.println("Image not found: " + imagePath);
            return null;
        }

        return new ImageIcon(imagePath);
    }

    public String getImagePath() {
        // Format the path based on the card's properties
        String imagePath = String.format("src/main/resources/img/%s_%s_%s_%s.png", color, number, shape, fill);
        return imagePath;
    }
}
