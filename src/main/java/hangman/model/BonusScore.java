package hangman.model;

public class BonusScore implements GameScore{

    private GameModel gameModel;
    public BonusScore(GameModel gameModel) {
        this.gameModel = gameModel;
    }
    /***
     * @pre
     * @pos
     * @param
     * @return score, de tipo int
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
