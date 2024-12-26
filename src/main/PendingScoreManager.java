package main;

import java.util.ArrayList;

public class PendingScoreManager {
    private int score;

    private boolean colorMatchCheck;
    private boolean numberMatchCheck;
    private boolean shapeMatchCheck;
    private boolean fillMatchCheck;







    public PendingScoreManager() {
        this.score = 0;
    }

   
    public void setCards(ArrayList<Card> cards) {

        // Check to make sure there are 3 cards in the pending area
        if (cards.size() != 3) {
            System.out.println("Error: Incorrect number of cards in pending area");
            this.score = 0;
            this.colorMatchCheck = false;
            this.numberMatchCheck = false;
            this.shapeMatchCheck = false;
            this.fillMatchCheck = false;
            return;
        }
        
        if (cards.get(0).getColor().equals(cards.get(1).getColor()) && cards.get(0).getColor().equals(cards.get(2).getColor())) {
            this.colorMatchCheck = true;
        } else {
            this.colorMatchCheck = false;
        }

        if (cards.get(0).getNumber().equals(cards.get(1).getNumber()) && cards.get(0).getNumber().equals(cards.get(2).getNumber())) {
            this.numberMatchCheck = true;
        } else {
            this.numberMatchCheck = false;
        }

        if (cards.get(0).getShape().equals(cards.get(1).getShape()) && cards.get(0).getShape().equals(cards.get(2).getShape())) {
            this.shapeMatchCheck = true;
        } else {
            this.shapeMatchCheck = false;
        }

        if (cards.get(0).getFill().equals(cards.get(1).getFill()) && cards.get(0).getFill().equals(cards.get(2).getFill())) {
            this.fillMatchCheck = true;
        } else {
            this.fillMatchCheck = false;
        }
        
    }

    public void calculateScore() {
        if (this.colorMatchCheck) {
            this.score += 10;
        }
        if (this.numberMatchCheck) {
            this.score += 10;
        }
        if (this.shapeMatchCheck) {
            this.score += 10;
        }
        if (this.fillMatchCheck) {
            this.score += 10;
        }
    }

    public int getScoreInt() {
        return this.score;
    }

    public String getScoreString() {
        return Integer.toString(this.score);
    }

    public void printScore() {
        System.out.println("Score: " + this.score);
    }
}
