/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

/**
 *
 * @author David Perez , Nicolas Camacho
 */
public class BonusScore implements GameScore {
    private int puntaje ;
    private int fallo = 5;
    private int bonus = 10;
    private int puntajeMinimo = 0;

    @Override
    
    public int calculateScore(int correcto , int incorrecto)throws GameScoreException {
        puntaje =0;
        if (correcto < 0 || incorrecto < 0){
            throw new GameScoreException (GameScoreException.NEGATIVE_NUMBERS);
        }
        
        puntaje = (puntaje+ (correcto * bonus) - (fallo *incorrecto) < puntajeMinimo)? puntajeMinimo : puntaje + (correcto *bonus)- (fallo * incorrecto);
        return puntaje;
    }
    
}
