/*---------------------------------------------------------------*/
/** Fichier : Launch.java
 *
 * créé le 23 janv. 2014 à 08:17:01
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm;

import java.io.IOException;
import java.net.UnknownHostException;

import ihm.view.MainFrame;

import javax.swing.JFrame;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class Launch
{

	/*---------------------------------------------------------------*/
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame mainView;
		try {
			mainView = new MainFrame();
			mainView.setVisible(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier Launch.java
/*---------------------------------------------------------------*/