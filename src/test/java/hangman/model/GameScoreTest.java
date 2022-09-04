package hangman.model;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

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

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
