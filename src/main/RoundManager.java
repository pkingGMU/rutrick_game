package main;

public class RoundManager {

    int round = 1;
    int endround = 1;

    public RoundManager() {
        this.round = 1;
    }

    public void nextRound() {
        this.round++;
    }

    public int getRound() {
        return this.round;
    }

    public boolean isEndRound() {
        return this.round == this.endround;
    }

    public void printRound() {
        System.out.println("Round: " + this.round);
    }
    
}
