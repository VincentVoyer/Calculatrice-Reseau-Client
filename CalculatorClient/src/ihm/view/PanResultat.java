/*---------------------------------------------------------------*/
/**
 * Fichier : PanResultat.java
 * 
 * créé le 23 janv. 2014 à 08:18:56
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import ihm.controler.Controler;
import ihm.model.Model;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*---------------------------------------------------------------*/
/**
 * The Class PanResultat.
 * 
 * @author vivoyer
 */
public class PanResultat extends JPanel
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -72260732776426287L;

	/**
	 * Instantiates a new pan resultat.
	 * 
	 * @param mdl
	 *            the mdl
	 * @param ctrl
	 *            the ctrl
	 */
	public PanResultat(final Model mdl,
			@SuppressWarnings("unused") final Controler ctrl)
	{
		setLayout(new GridLayout());
		final JList<String> jList = new JList<>(mdl.getModelList());
		final JScrollPane sc = new JScrollPane(jList);
		add(sc);
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier PanResultat.java
 * /*---------------------------------------------------------------
 */
