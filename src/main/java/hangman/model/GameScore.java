package hangman.model;

public interface GameScore {
    public int calculateScore(int correctCount, int incorrectCount, GameModel gameModel);
    public int getScore();
    public void reset();
    public void setScore(int newScore);
}
