package hangman.model;

import org.junit.Test;
import hangman.model.*;
import org.junit.Assert;

/**
 *@author David Pérez, Nicolas Camacho 
 * 
 * ______________________________________________________________
 * OriginalScore
 * 
 * fallo = 10;
 * 
 * Number               ClaseEquivalencia           Result
 * 1.                       correcto < 0            Incorrect - throws Negative Numbers  
 * 2.                       incorrecto < 0          Incorrect - throws Negative Numbers 
 * 3.             correcto >=0 and incorrecto = 0   Correct - 100
 * 4.             correcto >=0 and incorrecto > 10  Correct - 0
 * 
 * _________________________________________________________________
 * BonusScore
 * fallo = 5;
 * bonus = 10;
 * 
 * Number               ClaseEquivalencia           Result
 * 1.                       correcto < 0            Incorrect - throws Negative Numbers  
 * 2.                       incorrecto < 0          Incorrect - throws Negative Numbers 
 * 3.             correcto >=0 and incorrecto >= 0  Correct - 0
 *                  and (2)incorrecto>= correcto 
 * ___________________________________________________________________
 * PowerScore
 * fallo = 8;
 * bonus = 5 ** correcto;
 * Number               ClaseEquivalencia           Result
 * 1.                       correcto < 0            Incorrect - throws Negative Numbers  
 * 2.                       incorrecto < 0          Incorrect - throws Negative Numbers 
 * 3.                       incorrecto = 0 and 
 *                             correcto >= 4        Correct - 500
 * 4.                       incorrecto >=0 and 
 *                                  correct = 0     Correct - 0
 * ________________________________________________________________________________________
 
 */

public class GameScoreTest{
    private GameScore originalGame = new OriginalScore();
    private GameScore bonusGame = new BonusScore();
    private GameScore powerGame = new PowerScore();
    
    
    /*
    Alguno de los dos numeros es negativo
    */
    @Test
    public void deberiaLanzarExcepcion(){
        try{
            originalGame.calculateScore(-1,0);
        }
        catch( Exception e ){
            Assert.assertTrue( true );
        }
    }
    
    // No tiene ninguno incorrecto el puntaje sera 100 al no fallar ninguno
    @Test
    public void deberiaTenerElPuntajeMaximo() throws GameScoreException {
        int score = originalGame.calculateScore(100,0);
        Assert.assertEquals(score,100);

    }
    
    // Tiene más de 10 incorrectas por lo cual va perder 
    @Test
    public void deberiaTenerPuntajeMinimo() throws GameScoreException {
        int score = originalGame.calculateScore(26,11);
        Assert.assertEquals(score,0);

    }
    
/*BonusScore
    
    */ 
    
    /*Ningun numero es negativo
    
    */
    @Test
    public void deberiaLanzarExcepciondeBonus(){
        try{

            bonusGame.calculateScore(-1,-1);
        }
        catch( Exception e ){
            Assert.assertTrue( true );
        }
    }
    
    @Test
    public void deberiaLanzarelMinimoPuntaje() throws GameScoreException {
        int score = bonusGame.calculateScore(0,0);
        Assert.assertEquals(score,0);

    }
    
    
    /*PowerScore
    
    */
    
    
    @Test
    public void deberiaLanzarExcepcionPower(){
        try{
            powerGame.calculateScore(-1,-1);
        }
        catch( Exception e ){
            Assert.assertTrue( true );
        }
    }


    /*  
     @Test
    public void deberiaLanzarMaximoPuntaje() throws GameScoreException {
        int score = powerGame.calculateScore(4,0);
        Assert.assertTrue(score == 500);

    }

    */
    
    @Test
    public void deberiaLanzarMinimPuntaje() throws GameScoreException {
        int score = powerGame.calculateScore(0,15);
        Assert.assertEquals(score,0);

    }
    
    
    
    
    
    
    
    
    
}


