package hangman.model;

/**
 * @author David Perez, Nicolas Camacho

 * @version 1.0 8/27/2020
 */
public interface GameScore {
    
    public int calculateScore( int correcto, int incorrecto ) throws GameScoreException;

}