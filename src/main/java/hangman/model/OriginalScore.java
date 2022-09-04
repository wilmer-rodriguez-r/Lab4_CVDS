package hangman.model;

public class OriginalScore implements GameScore {

    private GameModel gameModel;
    public OriginalScore(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    /***
     * @pre
     * @pos
     * @param
     * @return score, de tipo int
     */
    public int calculateScore(int correctCount, int incorrectCount) {
        if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() >= 10) {
            gameModel.setScore(gameModel.getScore() - 10);
        }
        return gameModel.getScore();
    }
}
