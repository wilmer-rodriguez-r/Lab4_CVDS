package hangman.model;

import static org.junit.Assert.assertTrue;

import hangman.model.dictionary.EnglishDictionaryDataSource;
import hangman.model.dictionary.HangmanDictionary;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/***
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
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(70);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount() );
        Assert.assertEquals(70, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs70_then_newScoreIs60() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(70);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(60, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedCorrectly_when_scoreIs0_then_newScoreIs0(){
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(0);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount() );
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(0);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedCorrectly_when_scoreIs100_then_newScoreIs100(){
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(100);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount() );
        Assert.assertEquals(100, gameScore);
    }

    @Test
    public void given_aOriginalScore_userGuessedWrongly_when_scoreIs100_then_newScoreIs90() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(100);
        GameScore score = new OriginalScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(90, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedCorrectly_when_scoreIs150_then_newScoreIs160() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(150);
        GameScore score = new BonusScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount() );
        Assert.assertEquals(160, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedWrongly_when_scoreIs150_then_newScoreIs145() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(150);
        GameScore score = new BonusScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(145, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedCorrectly_when_scoreIs0_then_newScoreIs10() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(0);
        GameScore score = new BonusScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 1, gameModel.getIncorrectCount() );
        Assert.assertEquals(10, gameScore);
    }

    @Test
    public void given_aBonusScore_and_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(0);
        GameScore score = new BonusScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedCorrectly_when_scoreIs70_then_newScoreIs70() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(70);
        GameScore score = new PowerScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 2, gameModel.getIncorrectCount() );
        Assert.assertEquals(95, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedWrongly_when_scoreIs70_then_newScoreIs62() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(70);
        GameScore score = new PowerScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(62, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedWrongly_when_scoreIs0_then_newScoreIs0() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(0);
        GameScore score = new PowerScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount(), gameModel.getIncorrectCount() + 1);
        Assert.assertEquals(0, gameScore);
    }

    @Test
    public void given_aPowerScore_and_userGuessedCorrectly_when_scoreIs450_then_newScoreIs500() {
        GameModel gameModel = new GameModel(new EnglishDictionaryDataSource());
        gameModel.setScore(450);
        GameScore score = new PowerScore(gameModel);
        int gameScore = score.calculateScore(gameModel.getCorrectCount() + 3, gameModel.getIncorrectCount());
        Assert.assertEquals(500, gameScore);
    }
}
