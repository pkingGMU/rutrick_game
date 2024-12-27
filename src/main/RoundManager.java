package main;

public class RoundManager {

    int round = 1;
    int endround = 3;
    int stage = 1;
    int endStage = 3;

    public RoundManager() {
        this.round = 1;
        this.stage = 1;
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

    public void nextStage() {
        this.stage++;
    }

    public void resetStage() {
        this.stage = 0;
    }

    public int getStage() {
        return this.stage;
    }

    public boolean isEndStage() {
        return this.stage == this.endStage;
    }
    
}
