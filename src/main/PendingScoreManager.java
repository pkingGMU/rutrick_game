package main;

import java.util.ArrayList;

public class PendingScoreManager {
    private int score;
    private int money;

    private boolean colorMatchCheck;
    private boolean numberMatchCheck;
    private boolean shapeMatchCheck;
    private boolean fillMatchCheck;

    private String color;
    private String number;
    private String shape;
    private String fill;

    private ArrayList<Card> cards;







    public PendingScoreManager(ArrayList<Card> cards) {
        this.score = 0;
        this.money = 0;
        this.cards = cards;
    }

   
    public void setCards(ArrayList<Card> cards) {

        // Check to make sure there are 3 cards in the pending area
        if (cards.size() != 3) {
            System.out.println("Error: Incorrect number of cards in pending area");
            this.score = 0;
            this.money = 0;
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

            color = cards.get(0).getColor();

            switch(color) {
                case "Red": 
                        this.score = 5;
                    break;
                case"Green":
                        this.score = 10;
                    break;
                case "Blue": 
                        this.score = 15;
                    break;
            }

            
        }
        if (this.numberMatchCheck) {

            number = cards.get(0).getNumber();

            switch(number) {
                case "1":
                        this.score = 5;
                    break;
                case "2":
                        this.score = 10;
                    break;
                case "3":
                        this.score = 15;
                    break;
            }
            
        }
        if (this.shapeMatchCheck) {

            shape = cards.get(0).getShape();
            
            switch (shape) {
                case "Circle":
                    break;
                case "Square":
                    break;
                case "Triangle":
                    break;
            }
        }
        if (this.fillMatchCheck) {

            fill = cards.get(0).getShape();
            
            switch (fill) {
                case "Solid":
                    break;
                case "Striped":
                    break;
                case "Empty":
                    break;
            }
        }
    }

    public void calculateMoney() {
        if (this.colorMatchCheck) {

            color = cards.get(0).getColor();

            switch(color) {
                case "Red": 
                    break;
                case"Green":
                    break;
                case "Blue": 
                    break;
            }

            
        }
        if (this.numberMatchCheck) {

            number = cards.get(0).getNumber();

            switch(number) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
            }
            
        }
        if (this.shapeMatchCheck) {

            shape = cards.get(0).getShape();
            
            switch (shape) {
                case "Circle":
                    break;
                case "Square":
                    break;
                case "Triangle":
                    break;
            }
        }
        if (this.fillMatchCheck) {

            fill = cards.get(0).getShape();
            
            switch (fill) {
                case "Solid":
                    break;
                case "Striped":
                    break;
                case "Empty":
                    break;
            }
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

    public int getMoneyInt() {
        return this.money;
    }

    public String getMoneyString() {
        return Integer.toString(this.money);
    }

    public void printMoney() {
        System.out.println("Money: " + this.money);
    }
}
