package main;

public class TotalScoreManager {

    private int totalScore;
    private int totalMoney;

    public TotalScoreManager() {
        this.totalScore = 0;
        this.totalMoney = 0;
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

    public void updateTotalMoney(int money) {
        this.totalMoney += money;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public String getTotalMoneyString() {
        return Integer.toString(totalMoney);
    }

    public void resetTotalMoney() {
        this.totalMoney = 0;
    }

    public void printTotalMoney() {
        System.out.println("Total Money: " + totalMoney);
    }
    
}
