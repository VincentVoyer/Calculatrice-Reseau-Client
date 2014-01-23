/*---------------------------------------------------------------*/
/** Fichier : ModelResultList.java
 *
 * créé le 23 janv. 2014 à 08:22:58
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class ModelResultList extends AbstractListModel<String>
{
	
	private List<String> results;

	
	public ModelResultList()
	{
		results = new ArrayList<String>();
	}
	
	public void addResult(String result)
	{
		
	}
	
	/*---------------------------------------------------------------*/
	/**
	 * @param arg0
	 * @return
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public String getElementAt(int arg0)
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		return null;
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize()
	{
		// PENSER à IMPLEMENTER Auto-generated method stub
		return 0;
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier ModelResultList.java
/*---------------------------------------------------------------*/