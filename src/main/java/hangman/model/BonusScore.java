package hangman.model;

public class BonusScore implements GameScore{

    private int score;
    public BonusScore() {
        score = 0;
    }
    /***
     * @pre gameScore > 0 && correctCount > 0 && incorrectCount > 0
     * @pos gameScore > 0
     * @param correctCount number of corrects letters the player has guessed
     * @param incorrectCount number of incorrect letters the player has guessed
     * @return score type int
     */
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (correctCount > gameModel.getCorrectCount()) {
            score = gameModel.getScore() + 10;
        } else if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 5) {
            score = gameModel.getScore() - 5;
        }
        return gameModel.getScore();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset() {
        score = 0;
    }

    @Override
    public void setScore(int newScore) {
        score = newScore;
    }
}
