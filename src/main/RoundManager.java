package main;

public class RoundManager {

    private int round = 1;
    private int endround = 2;
    private int stage = 1;
    private int endStage = 2;
    private int segment = 1;
    private int endSegment = 1;

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

    public void resetRound() {
        this.round = 1;
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
        this.stage = 1;
    }

    public int getStage() {
        return this.stage;
    }

    public void printStage() {
        System.out.println("Stage: " + this.stage);
    }

    public boolean isEndStage() {
        return this.stage == this.endStage;
    }

    public void resetSegment() {
        this.segment = 1;
    }
    
    public void nextSegment() {
        this.segment += 1;
    }

    public int getSegment() {
        return this.segment;
    }

    public boolean isEndSegment() {
        return this.segment == this.endSegment;
    }
}
