package hangman.model;

public class PowerScore implements GameScore{

    private int score;
    public PowerScore() {
        score = 0;
    }

    /***
     * @pre gameScore > 0 && correctCount > 0 && incorrectCount > 0
     * @pos gameScore > 0 && gameScore < 500
     * @param correctCount number of corrects letters the player has guessed
     * @param incorrectCount number of incorrect letters the player has guessed
     * @return score type int
     */
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (correctCount > gameModel.getCorrectCount()) {
            int pow = (int) Math.pow(5, Math.abs(correctCount - gameModel.getCorrectCount()));
            score = Math.min(pow + gameModel.getScore(), 500);
        } else if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 8) {
            score = gameModel.getScore() - 8;
        }
        return score;
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
