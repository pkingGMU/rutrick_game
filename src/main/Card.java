package main;

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

    public ImageIcon getImageIcon() {
        String imagePath = getImagePath();
        

        if (imagePath == null) {
            System.err.println("Image not found: " + imagePath);
            return null;
        }

        return new ImageIcon(imagePath);
    }

    public String getImagePath() {
        String imagePath = String.format("src/main/resources/img/%s_%s_%s_%s.png", color, number, shape, fill);
        return imagePath;
    }
    
    
}
