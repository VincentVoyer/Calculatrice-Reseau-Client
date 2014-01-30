/*---------------------------------------------------------------*/
/** Fichier : PanResultat.java
 *
 * créé le 23 janv. 2014 à 08:18:56
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import ihm.controler.Controler;
import ihm.model.Model;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class PanResultat extends JPanel
{
	public PanResultat(Model mdl, Controler ctrl)
	{
		setLayout(new GridLayout());
		JScrollPane sc = new JScrollPane(new JList(mdl.getModelList()));
		add(sc);
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier PanResultat.java
/*---------------------------------------------------------------*/