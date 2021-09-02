package hangman.model;

/**
 * @author David Perez , Nicolas Camacho
 
 */
public class GameScoreException extends Exception {
    public static final String NEGATIVE_NUMBERS = "No pueden haber numeros negativos";
    public GameScoreException(String message ){
        super( message);
    }
}