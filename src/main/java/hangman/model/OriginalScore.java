package hangman.model;

//import com.sun.org.apache.xpath.internal.operations.Or;

public class OriginalScore implements GameScore {

    private int score;
    public OriginalScore() {
        score = 100;
    }
    /***
     * @pre gameScore > 0 && correctCount > 0 && incorrectCount > 0
     * @pos gameScore > 0 && gameScore < 100
     * @param correctCount number of corrects letters the player has guessed
     * @param incorrectCount number of incorrect letters the player has guessed
     * @return score type int
     */
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel) {
        if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 10) {
            score = gameModel.getScore() - 10;
        }
        return gameModel.getScore();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset() {
        score = 100;
    }

    @Override
    public void setScore(int newScore) {
        score = newScore;
    }
}
