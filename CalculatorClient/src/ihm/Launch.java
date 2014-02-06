/*---------------------------------------------------------------*/
/**
 * Fichier : Launch.java
 * 
 * créé le 23 janv. 2014 à 08:17:01
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm;

import ihm.view.MainFrame;
import java.io.IOException;
import javax.swing.JFrame;

/*---------------------------------------------------------------*/
/**
 * The Class Launch.
 * 
 * @author vivoyer
 */
public class Launch
{
	/*---------------------------------------------------------------*/
	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		JFrame mainView;
		try
		{
			mainView = new MainFrame();
			mainView.setVisible(true);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier Launch.java
 * /*---------------------------------------------------------------
 */
