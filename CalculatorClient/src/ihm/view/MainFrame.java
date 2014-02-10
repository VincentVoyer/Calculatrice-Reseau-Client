/*---------------------------------------------------------------*/
/**
 * Fichier : MainFrame.java
 * 
 * créé le 23 janv. 2014 à 08:18:02
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import ihm.controler.Controler;
import ihm.model.Model;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/*---------------------------------------------------------------*/
/**
 * The Class MainFrame.
 * 
 * @author vivoyer
 */
public class MainFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -8817705407186564L;

	/**
	 * Instantiates a new main frame.
	 * 
	 * @param model
	 *            the model
	 */
	public MainFrame(final Model model)
	{
		super("Calculator client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		final Controler ctrl = new Controler(model);
		setLayout(new BorderLayout());
		add(new PanCalculator(model, ctrl), BorderLayout.CENTER);
		add(new PanResultat(model, ctrl), BorderLayout.EAST);
		setSize(700, 500);
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier MainFrame.java
 * /*---------------------------------------------------------------
 */
