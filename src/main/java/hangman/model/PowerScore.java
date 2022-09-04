package hangman.model;

public class PowerScore implements GameScore{

    private GameModel gameModel;
    public PowerScore(GameModel gameModel) {
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
            int pow = (int) Math.pow(5, Math.abs(correctCount - gameModel.getCorrectCount()));
            gameModel.setScore(Math.min(pow + gameModel.getScore(), 500));
        } else if (incorrectCount > gameModel.getIncorrectCount() && gameModel.getScore() != 0) {
            gameModel.setScore(gameModel.getScore() - 8);
        }
        return gameModel.getScore();
    }
}
