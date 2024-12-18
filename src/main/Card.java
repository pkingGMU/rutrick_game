package main;

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
    
    
}
