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
import services.ProtocolCommandes;

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
			final String actionCommand = btn.getActionCommand();
			if (ProtocolCommandes.ADD.toString().equals(actionCommand))
			{
				operation = true;
				mdl.modifOperande1(op1.toString());
				mdl.modifOperation("+");
			}
			else if (ProtocolCommandes.MIN.toString().equals(actionCommand))
			{
				operation = true;
				mdl.modifOperande1(op1.toString());
				mdl.modifOperation("-");
			}
			else if (ProtocolCommandes.MUL.toString().equals(actionCommand))
			{
				operation = true;
				mdl.modifOperande1(op1.toString());
				mdl.modifOperation("*");
			}
			else if (ProtocolCommandes.DIV.toString().equals(actionCommand))
			{
				operation = true;
				mdl.modifOperande1(op1.toString());
				mdl.modifOperation("-");
			}
			else if (ProtocolCommandes.RES.toString().equals(actionCommand))
			{
				operation = false;
				mdl.modifOperande2(op2.toString());
				mdl.modifOperation("=");
				op1 = new StringBuilder();
				op2 = new StringBuilder();
			}
			else if (ProtocolCommandes.STAT.toString().equals(actionCommand))
			{
				mdl.requestStat();
			}
			else if (ProtocolCommandes.QUIT.toString().equals(actionCommand))
			{
				System.exit(0);
			}
			else
			{
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
