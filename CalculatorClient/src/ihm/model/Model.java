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

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class Model extends Observable implements Observer
{

	private float operande1;
	
	private float operande2;
	
	private AbstractListModel<String> mdlResult;
	
	public Model()
	{
		mdlResult = new ModelResultList();
	}
	
	public void modifOperande1(String op)
	{
		
	}
	
	public void modifOperande2(String op)
	{
		
	}
	
	
	
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

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	public ListModel getModelList()
	{
		return mdlResult;
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier Model.java
/*---------------------------------------------------------------*/