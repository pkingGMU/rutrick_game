package main;

import java.util.Objects;
import javax.swing.ImageIcon;

public class Card {

    private String color;
    private String number;
    private String shape;
    private String fill;

    private int cost;

    public Card(String color, String number, String shape, String fill) {
        this.color = color;
        this.number = number;
        this.shape = shape;
        this.fill = fill;

        this.cost = calculateCost(color, number, shape, fill);
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

    public int calculateCost(String color, String number, String shape, String fill) {

            this.cost = 0;

            

            switch(color) {
                case "Red": 
                    this.cost += 0;
                    break;
                case"Green":
                    this.cost += 2;
                    break;
                case "Blue": 
                    this.cost += 3;
                    break;
            }

            
        
        

            switch(number) {
                case "1":
                    this.cost += 30;
                    break;
                case "2":
                    this.cost += 40;
                    break;
                case "3":
                    this.cost += 50;
                    break;
            }
            
        
        
            
            switch (shape) {
                case "Circle":
                    this.cost += 0;
                    break;
                case "Square":
                    this.cost += 10;
                    break;
                case "Triangle":
                    this.cost += 15;
                    break;
            }
        
        
            
            switch (fill) {
                case "Solid":
                    this.cost += 0;
                    break;
                case "Striped":
                    this.cost += 5;
                    break;
                case "Empty":
                    this.cost += 10;
                    break;
            }

            return cost;

    }

    public int getCardCost() {
        return this.cost;
    }

    public String getCardCostString() {
        return Integer.toString(this.cost);
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
