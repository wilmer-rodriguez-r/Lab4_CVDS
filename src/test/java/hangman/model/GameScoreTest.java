package hangman.model;

import static org.junit.Assert.assertTrue;

import hangman.model.dictionary.EnglishDictionaryDataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * OriginalScore, Clases de equivalencia:
 *  - Limite Superior : puntaje > 100
 *  - Valido : 100 => puntaje >= 0
 *  - Limite Inferior : puntaje < 0
 *  - Condiciones de frontera:
 *      * puntaje = 100
 *      * puntaje = 0
 * BonusScore, Clases de equivalencia:
 *  - Valido : puntaje >= 0
 *  - Limite Inferior : puntaje < 0
 *  - Condiciones de frontera:
 *      * puntaje = 0
 * PowerBonusScore, Clases de equivalencia:
 *  - Limite Superior: puntaje > 500
 *  - Valido : 500 >= puntaje >= 0
 *  - Limite Inferior : puntaje < 0
 *  - Condiciones de frontera:
 *      * puntaje = 500
 *      * puntaje = 0
 */
public class GameScoreTest {

    @Test
    public void given_aOriginalScore_userGuessedCorrectly_when_scoreIs70_then_newScoreIs70() {
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(70);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(70, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs70_then_newScoreIs60() {
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(70);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(60, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedCorrectly_when_scoreIs0_then_newScoreIs0(){
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedCorrectly_when_scoreIs100_then_newScoreIs100(){
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(100);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(100, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs100_then_newScoreIs90() {
        GameScore score = new OriginalScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(100);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(90, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedCorrectly_when_scoreIs150_then_newScoreIs160() {
        GameScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(150);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(160, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedWrongly_when_scoreIs150_then_newScoreIs145() {
        GameScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(150);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(145, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedCorrectly_when_scoreIs0_then_newScoreIs10() {
        GameScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(10, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameScore score = new BonusScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedCorrectly_when_scoreIs70_then_newScoreIs70() {
        GameScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(70);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 2, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(95, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedWrongly_when_scoreIs70_then_newScoreIs62() {
        GameScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(70);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(62, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(0);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1, gameModel);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedCorrectly_when_scoreIs450_then_newScoreIs500() {
        GameScore score = new PowerScore();
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource(), score);
        gameModel.setScore(450);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 3, gameModel.getIncorrectCount(), gameModel);
        Assert.assertEquals(500, gameScore);
    }
}
