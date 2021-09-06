package hangman.model;

/**
	@author David Perez , Nicolas Camacho
*/

public class OriginalScore implements GameScore{
	private int puntaje;
	private int fallo = 10;
	private int puntajeMinimo = 0;
	
	
	@Override
	public int calculateScore(int correcto , int incorrecto)throws GameScoreException {
		puntaje = 100 ;
		if (correcto < 0 || incorrecto < 0) {
			throw new GameScoreException( GameScoreException.NEGATIVE_NUMBERS);
		}
		
		puntaje =( puntaje - (fallo*incorrecto) < puntajeMinimo )? puntajeMinimo :  puntaje - (fallo*incorrecto);
        return puntaje;
	}
	
}
