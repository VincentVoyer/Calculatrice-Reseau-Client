/*---------------------------------------------------------------*/
/**
 * Fichier : Launch.java
 * 
 * créé le 23 janv. 2014 à 08:17:01
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm;

import ihm.model.Model;
import ihm.view.MainFrame;
import java.io.IOException;
import javax.swing.JFrame;
import services.CommunicationService;

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
		CommunicationService communicationService = null;
		try
		{
			if (args.length > 0)
			{
				communicationService = new CommunicationService(
						Integer.parseInt(args[0]));
			}
			else
			{
				communicationService = new CommunicationService(5042);
			}
		}
		catch (final IOException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		final Model model = new Model(communicationService);
		mainView = new MainFrame(model);
		mainView.setVisible(true);
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier Launch.java
 * /*---------------------------------------------------------------
 */
