/*---------------------------------------------------------------*/
/** Fichier : MainFrame.java
 *
 * créé le 23 janv. 2014 à 08:18:02
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import ihm.controler.Controler;
import ihm.model.Model;

import javax.swing.JFrame;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class MainFrame extends JFrame
{
	public MainFrame()
	{
		super("Calculator client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Model mdl = new Model();
		Controler ctrl = new Controler();
		
		setLayout(new BorderLayout());
		add(new PanCalculator(mdl, ctrl),BorderLayout.CENTER);
		add(new PanResultat(mdl, ctrl), BorderLayout.EAST);
		setSize(700, 500);
	}
}


/*---------------------------------------------------------------*/
/* Fin du fichier MainFrame.java
/*---------------------------------------------------------------*/