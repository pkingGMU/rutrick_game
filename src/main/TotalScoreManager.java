package main;

public class TotalScoreManager {

    private int totalScore;

    public TotalScoreManager() {
        this.totalScore = 0;
    }

    public void updateTotalScore(int score) {
        this.totalScore += score;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public String getTotalScoreString() {
        return Integer.toString(totalScore);
    }

    public void resetTotalScore() {
        this.totalScore = 0;
    }
    
    public void printTotalScore() {
        System.out.println("Total Score: " + totalScore);
    }
    
}
