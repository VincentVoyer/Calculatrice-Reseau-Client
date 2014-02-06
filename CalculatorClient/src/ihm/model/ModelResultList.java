/*---------------------------------------------------------------*/
/**
 * Fichier : ModelResultList.java
 * 
 * créé le 23 janv. 2014 à 08:22:58
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;

// TODO: Auto-generated Javadoc
/*---------------------------------------------------------------*/
/**
 * The Class ModelResultList.
 * 
 * @author vivoyer
 */
public class ModelResultList extends AbstractListModel<String>
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4826520644062734559L;
	/** The results. */
	private final List<String>	results;

	/**
	 * Instantiates a new model result list.
	 */
	public ModelResultList()
	{
		results = new ArrayList<>();
	}

	/**
	 * Adds the result.
	 * 
	 * @param result
	 *            the result
	 */
	public void addResult(final String result)
	{
		results.add(result);
		fireContentsChanged(results, 0, getSize());
	}

	/*---------------------------------------------------------------*/
	/**
	 * Gets the element at.
	 * 
	 * @param arg0
	 *            the arg0
	 * @return the element at
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	@Override
	public String getElementAt(final int arg0)
	{
		return results.get(arg0);
	}

	/*---------------------------------------------------------------*/
	/**
	 * Gets the size.
	 * 
	 * @return the size
	 * @see javax.swing.ListModel#getSize()
	 */
	@Override
	public int getSize()
	{
		return results.size();
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier ModelResultList.java
 * /*---------------------------------------------------------------
 */
