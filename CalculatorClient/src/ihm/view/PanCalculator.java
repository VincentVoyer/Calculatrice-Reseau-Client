/*---------------------------------------------------------------*/
/** Fichier : PanCalculator.java
 *
 * créé le 23 janv. 2014 à 08:18:43
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import ihm.controler.Controler;
import ihm.model.Model;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import static services.ProtocolCommandes.*;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *	
 */
public class PanCalculator extends JPanel
{
	public PanCalculator(Model mdl, Controler ctrl)
	{
		setLayout(new BorderLayout());
		
		add(createPanButtonCal(ctrl),BorderLayout.CENTER);
		add(createPanButtonExit(ctrl),BorderLayout.SOUTH);
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	private Component createPanButtonExit(ActionListener ctrl)
	{
		JPanel panExit = new JPanel();
		
		panExit.add(createButton("Exit", QUIT.toString(), ctrl));
		panExit.add(createButton("Stat", STAT.toString(), ctrl));
		
		return panExit;
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	private Component createPanButtonCal(ActionListener ctrl)
	{
		JPanel panCalc = new JPanel(new BorderLayout());
		
		panCalc.add(createPanNum(ctrl),BorderLayout.CENTER);
		panCalc.add(createPanOp(ctrl),BorderLayout.EAST);
		
		return panCalc;
	}
	
	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	private Component createPanNum(ActionListener ctrl)
	{
		JPanel panNum = new JPanel(new GridLayout(4,3));
		
		
		panNum.add(createButton("1", "1", ctrl));
		panNum.add(createButton("2", "2", ctrl));
		panNum.add(createButton("3", "3", ctrl));
		panNum.add(createButton("4", "4", ctrl));
		panNum.add(createButton("5", "5", ctrl));
		panNum.add(createButton("6", "6", ctrl));
		panNum.add(createButton("7", "7", ctrl));
		panNum.add(createButton("8", "8", ctrl));
		panNum.add(createButton("9", "9", ctrl));
		panNum.add(createButton("0", "0", ctrl));
		panNum.add(createButton(",", ",", ctrl));
		
		return panNum;
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	private Component createPanOp(ActionListener ctrl)
	{
		JPanel panOp = new JPanel(new GridLayout(3,2));
		
		panOp.add(createButton("+", ADD.toString(), ctrl));
		panOp.add(createButton("-", MIN.toString(), ctrl));
		panOp.add(createButton("*", MUL.toString(), ctrl));
		panOp.add(createButton("/", DIV.toString(), ctrl));
		panOp.add(createButton("=", RES.toString(), ctrl));
		
		return panOp;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Create a button.
	 * @param name button's name.
	 * @param action button's action
	 * @param ctrl button's listerner. 
	 * @return new button.
	 */
	private JComponent createButton(String name, String action, ActionListener ctrl)
	{
		JButton button = new JButton(name);
		
		button.setActionCommand(action);
		button.addActionListener(ctrl);
		
		return button;
	}
}


/*---------------------------------------------------------------*/
/* Fin du fichier PanCalculator.java
/*---------------------------------------------------------------*/