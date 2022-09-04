package hangman.model;

public class BonusScore implements GameScore{

    private GameModel gameModel;
    public BonusScore(GameModel gameModel) {
        this.gameModel = gameModel;
    }
    /***
     * @pre gameScore > 0 && correctCount > 0 && incorrectCount > 0
     * @pos gameScore > 0
     * @param correctCount number of corrects letters the player has guessed
     * @param incorrectCount number of incorrect letters the player has guessed
     * @return score type int
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        if (correctCount > gameModel.getCorrectCount()) {
            gameModel.setScore(gameModel.getScore() + 10);
        } else if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() != 0) {
            gameModel.setScore(gameModel.getScore() - 5);
        }
        return gameModel.getScore();
    }
}
