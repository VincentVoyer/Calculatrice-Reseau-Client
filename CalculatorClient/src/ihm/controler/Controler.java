/*---------------------------------------------------------------*/
/**
 * Fichier : Controler.java
 * 
 * créé le 23 janv. 2014 à 08:19:53
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.controler;

import ihm.model.Model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*---------------------------------------------------------------*/
/**
 * The Class Controler.
 * 
 * @author vivoyer
 */
public class Controler implements ActionListener
{
	/** The mdl. */
	private final Model		mdl;
	/** The op1. */
	private StringBuilder	op1;
	/** The op2. */
	private StringBuilder	op2;
	/** The operation. */
	private boolean			operation;

	/**
	 * Instantiates a new controler.
	 * 
	 * @param m
	 *            the m
	 */
	public Controler(final Model m)
	{
		mdl = m;
		op1 = new StringBuilder();
		op2 = new StringBuilder();
	}

	/*---------------------------------------------------------------*/
	/**
	 * Action performed.
	 * 
	 * @param arg0
	 *            the arg0
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(final ActionEvent arg0)
	{
		if (arg0.getSource() instanceof JButton)
		{
			final JButton btn = (JButton) arg0.getSource();
			switch (btn.getActionCommand())
			{
				case "ADD":
					operation = true;
					mdl.modifOperande1(op1.toString());
					mdl.modifOperation("+");
					break;
				case "MIN":
					operation = true;
					mdl.modifOperande1(op1.toString());
					mdl.modifOperation("-");
					break;
				case "MUL":
					operation = true;
					mdl.modifOperande1(op1.toString());
					mdl.modifOperation("*");
					break;
				case "DIV":
					operation = true;
					mdl.modifOperande1(op1.toString());
					mdl.modifOperation("-");
					break;
				case "RES":
					operation = false;
					mdl.modifOperande2(op2.toString());
					mdl.modifOperation("=");
					op1 = new StringBuilder();
					op2 = new StringBuilder();
					break;
				default:
					if (operation)
					{
						op2.append(btn.getText());
						mdl.modifOperande2(op2.toString());
					}
					else
					{
						op1.append(btn.getText());
						mdl.modifOperande1(op1.toString());
					}
			}
		}
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier Controler.java
 * /*---------------------------------------------------------------
 */
