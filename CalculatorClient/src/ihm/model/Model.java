/*---------------------------------------------------------------*/
/**
 * Fichier : Model.java
 * 
 * créé le 23 janv. 2014 à 08:19:38
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.ListModel;
import services.CommunicationService;
import services.ProtocolCommandes;
import services.RequestOperation;

/*---------------------------------------------------------------*/
/**
 * The Class Model.
 * 
 * @author vivoyer
 */
public class Model extends Observable implements Observer
{
	/** The com. */
	private final CommunicationService	com;
	/** The mdl result. */
	private final ModelResultList		mdlResult;
	/** The op1. */
	private String						op1	= null;
	/** The op2. */
	private String						op2	= null;
	/** The operande1. */
	private float						operande1;
	/** The operande2. */
	private float						operande2;
	/** The operation. */
	private String						operation;
	/** The req. */
	private String						req	= null;

	/**
	 * Instantiates a new model.
	 * 
	 * @param communicationService
	 *            the com
	 */
	public Model(final CommunicationService communicationService)
	{
		mdlResult = new ModelResultList();
		this.com = communicationService;
		communicationService.addObserver(this);
	}

	/*---------------------------------------------------------------*/
	/**
	 * Gets the model list.
	 * 
	 * @return the model list
	 */
	public ListModel<String> getModelList()
	{
		return mdlResult;
	}

	/**
	 * Gets the request.
	 * 
	 * @return the request
	 */
	public String getRequest()
	{
		final StringBuilder sb = new StringBuilder();
		if (op1 != null)
		{
			sb.append(op1).append(" ");
			if (req != null)
			{
				sb.append(req).append(" ");
				if (op2 != null)
				{
					sb.append(op2);
				}
			}
		}
		return sb.toString();
	}

	/**
	 * Informer.
	 */
	private void informer()
	{
		setChanged();
		notifyObservers();
	}

	/**
	 * Modif operande1.
	 * 
	 * @param op
	 *            the op
	 */
	public void modifOperande1(final String op)
	{
		try
		{
			final float f = Float.parseFloat(op);
			operande1 = f;
			op1 = op;
			informer();
		}
		catch (final Exception e)
		{
		}
	}

	/**
	 * Modif operande2.
	 * 
	 * @param op
	 *            the op
	 */
	public void modifOperande2(final String op)
	{
		try
		{
			final float f = Float.parseFloat(op);
			operande2 = f;
			op2 = op;
			informer();
		}
		catch (final Exception e)
		{
		}
	}

	/**
	 * Modif operation.
	 * 
	 * @param operation
	 *            the operation
	 */
	public void modifOperation(String operation)
	{
		req = operation;
		switch (operation)
		{
			case "+":
				operation = ProtocolCommandes.ADD.toString();
				break;
			case "-":
				operation = ProtocolCommandes.MIN.toString();
				break;
			case "/":
				operation = ProtocolCommandes.DIV.toString();
				break;
			case "*":
				operation = ProtocolCommandes.MUL.toString();
				break;
			default:
				break;
		}
		if (operation.equals("="))
		{
			com.sendRequest(operande1, operande2, this.operation);
			op1 = null;
			op2 = null;
			req = null;
		}
		else
		{
			this.operation = operation;
		}
		informer();
	}

	/*---------------------------------------------------------------*/
	/**
	 * Update.
	 * 
	 * @param arg0
	 *            the arg0
	 * @param arg1
	 *            the arg1
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(final Observable arg0, final Object arg1)
	{
		if (arg0 instanceof CommunicationService)
		{
			if (arg1 instanceof RequestOperation)
			{
				final RequestOperation req = (RequestOperation) arg1;
				mdlResult.addResult(req.toString());
			}
			else if (arg1 instanceof String)
			{
				mdlResult.addResult(arg1.toString());
			}
		}
		else
		{
			informer();
		}
	}

	/* _________________________________________________________ */
	/**
	 * Request stat.
	 */
	public void requestStat()
	{
		com.sendRequestStat();
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier Model.java
 * /*---------------------------------------------------------------
 */
