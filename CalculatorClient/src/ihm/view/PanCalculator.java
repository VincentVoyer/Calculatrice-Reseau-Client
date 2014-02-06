/*---------------------------------------------------------------*/
/**
 * Fichier : PanCalculator.java
 * 
 * créé le 23 janv. 2014 à 08:18:43
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.view;

import static services.ProtocolCommandes.ADD;
import static services.ProtocolCommandes.DIV;
import static services.ProtocolCommandes.MIN;
import static services.ProtocolCommandes.MUL;
import static services.ProtocolCommandes.QUIT;
import static services.ProtocolCommandes.RES;
import static services.ProtocolCommandes.STAT;
import ihm.controler.Controler;
import ihm.model.Model;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*---------------------------------------------------------------*/
/**
 * The Class PanCalculator.
 * 
 * @author vivoyer
 */
public class PanCalculator extends JPanel implements Observer
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 5482469583420924190L;
	/** The request. */
	private JLabel				request;

	/**
	 * Instantiates a new pan calculator.
	 * 
	 * @param mdl
	 *            the mdl
	 * @param ctrl
	 *            the ctrl
	 */
	public PanCalculator(final Model mdl, final Controler ctrl)
	{
		setLayout(new BorderLayout());
		add(createPanButtonCal(ctrl), BorderLayout.CENTER);
		add(createPanButtonExit(ctrl), BorderLayout.SOUTH);
		mdl.addObserver(this);
	}

	/*---------------------------------------------------------------*/
	/**
	 * Create a button.
	 * 
	 * @param name
	 *            button's name.
	 * @param action
	 *            button's action
	 * @param ctrl
	 *            button's listerner.
	 * @return new button.
	 */
	private JComponent createButton(final String name, final String action,
			final ActionListener ctrl)
	{
		final JButton button = new JButton(name);
		button.setActionCommand(action);
		button.addActionListener(ctrl);
		return button;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Creates the pan button cal.
	 * 
	 * @param ctrl
	 *            the ctrl
	 * @return the component
	 */
	private Component createPanButtonCal(final ActionListener ctrl)
	{
		final JPanel panCalc = new JPanel(new BorderLayout());
		panCalc.add(createPanNum(ctrl), BorderLayout.CENTER);
		panCalc.add(createPanOp(ctrl), BorderLayout.EAST);
		return panCalc;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Creates the pan button exit.
	 * 
	 * @param ctrl
	 *            the ctrl
	 * @return the component
	 */
	private Component createPanButtonExit(final ActionListener ctrl)
	{
		final JPanel panExit = new JPanel();
		panExit.add(createButton("Exit", QUIT.toString(), ctrl));
		panExit.add(createButton("Stat", STAT.toString(), ctrl));
		return panExit;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Creates the pan num.
	 * 
	 * @param ctrl
	 *            the ctrl
	 * @return the component
	 */
	private Component createPanNum(final ActionListener ctrl)
	{
		final JPanel panFull = new JPanel(new GridLayout(2, 1));
		final JPanel panNum = new JPanel(new GridLayout(4, 3));
		request = new JLabel();
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
		panNum.add(createButton(".", ".", ctrl));
		panFull.add(request);
		panFull.add(panNum);
		return panFull;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Creates the pan op.
	 * 
	 * @param ctrl
	 *            the ctrl
	 * @return the component
	 */
	private Component createPanOp(final ActionListener ctrl)
	{
		final JPanel panOp = new JPanel(new GridLayout(3, 2));
		panOp.add(createButton("+", ADD.toString(), ctrl));
		panOp.add(createButton("-", MIN.toString(), ctrl));
		panOp.add(createButton("*", MUL.toString(), ctrl));
		panOp.add(createButton("/", DIV.toString(), ctrl));
		panOp.add(createButton("=", RES.toString(), ctrl));
		return panOp;
	}

	/*---------------------------------------------------------------*/
	/**
	 * Update.
	 * 
	 * @param o
	 *            the o
	 * @param arg
	 *            the arg
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(final Observable o,
			@SuppressWarnings("unused") final Object arg)
	{
		if (o instanceof Model)
		{
			final Model m = (Model) o;
			request.setText("");
			request.setText(m.getRequest());
		}
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier PanCalculator.java
 * /*---------------------------------------------------------------
 */
