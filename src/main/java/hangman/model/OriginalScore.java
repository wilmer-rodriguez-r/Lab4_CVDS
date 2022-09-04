package hangman.model;

public class OriginalScore implements GameScore {

    private GameModel gameModel;
    public OriginalScore(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    /***
     * @pre gameScore > 0 && correctCount > 0 && incorrectCount > 0
     * @pos gameScore > 0 && gameScore < 100
     * @param correctCount number of corrects letters the player has guessed
     * @param incorrectCount number of incorrect letters the player has guessed
     * @return score type int
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 10) {
            gameModel.setScore(gameModel.getScore() - 10);
        }
        return gameModel.getScore();
    }
}
