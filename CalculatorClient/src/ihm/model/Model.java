/*---------------------------------------------------------------*/
/** Fichier : Model.java
 *
 * créé le 23 janv. 2014 à 08:19:38
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.model;

import java.util.Observable;
import java.util.Observer;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class Model extends Observable implements Observer
{

	/*---------------------------------------------------------------*/
	/**
	 * @param arg0
	 * @param arg1
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub

	}
	
	private void informer()
	{
		setChanged();
		notifyObservers();
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier Model.java
/*---------------------------------------------------------------*/