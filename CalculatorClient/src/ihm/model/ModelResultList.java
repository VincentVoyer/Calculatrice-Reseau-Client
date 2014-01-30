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

import javax.sound.sampled.ReverbType;
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
		results.add(result);
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
		return results.get(arg0);
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize()
	{
		return results.size();
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier ModelResultList.java
/*---------------------------------------------------------------*/