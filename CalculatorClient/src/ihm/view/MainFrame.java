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
import java.io.IOException;
import java.net.UnknownHostException;
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
	 * @throws UnknownHostException
	 *             the unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public MainFrame() throws UnknownHostException, IOException
	{
		super("Calculator client");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		final Model mdl = new Model();
		final Controler ctrl = new Controler(mdl);
		setLayout(new BorderLayout());
		add(new PanCalculator(mdl, ctrl), BorderLayout.CENTER);
		add(new PanResultat(mdl, ctrl), BorderLayout.EAST);
		setSize(700, 500);
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier MainFrame.java
 * /*---------------------------------------------------------------
 */
