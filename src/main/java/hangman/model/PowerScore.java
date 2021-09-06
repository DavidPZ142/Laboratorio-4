/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;
import java.lang.Math;
/**
 *
 * @author david
 */
public class PowerScore implements GameScore{
    private int puntaje;
    private int bonus = 5;
    private int fallo = 8;
    private int puntajeMinimo = 0;
    private int puntajeMaximo = 500;
    
    @Override
    public int calculateScore(int correcto , int incorrecto)throws GameScoreException {
        puntaje =0;
        if (correcto < 0 || incorrecto < 0){
            throw new GameScoreException (GameScoreException.NEGATIVE_NUMBERS);
        }
        for (int i= 1 ; i < correcto ; i++){
            puntaje+= (Math.pow(bonus,i));
        }
        
       puntaje = (puntaje -(fallo*incorrecto)< puntajeMinimo) ? puntajeMinimo : puntaje - (fallo*incorrecto);
       puntaje = (puntaje  > puntajeMaximo )? puntajeMaximo : puntaje;
       
       return puntaje;
    }
}
