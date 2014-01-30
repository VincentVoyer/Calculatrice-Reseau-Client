/*---------------------------------------------------------------*/
/** Fichier : Model.java
 *
 * créé le 23 janv. 2014 à 08:19:38
 *
 * Auteurs : Léo Riera & Vincent Voyer
 */
package ihm.model;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

import services.CommunicationService;
import services.ProtocolCommandes;
import services.RequestOperation;
import services.RequestSender;
import services.ResultReceiv;

/*---------------------------------------------------------------*/
/**
 * @author vivoyer
 *
 */
public class Model extends Observable implements Observer
{

	private float operande1;
	
	private float operande2;
	
	private String operation;
	
	private float resultat = 0;
	
	private CommunicationService com;
	
	private ModelResultList mdlResult;
	
	private String op1 = null;
	
	private String op2 = null;
	
	private String req = null;
	
	public Model() throws UnknownHostException, IOException
	{
		mdlResult = new ModelResultList();
		com = new CommunicationService();
		com.addObserver(this);
	}
	
	public void modifOperande1(String op)
	{
		try
		{
			float f = Float.parseFloat(op);
			operande1= f;
			op1 = op;;
			informer();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void modifOperande2(String op)
	{
		try
		{
			float f = Float.parseFloat(op);
			operande2= f;
			op2 = op;
			informer();
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void modifOperation(String operation)
	{
		req = operation;
		switch(operation)
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
		}
		if(operation.equals("="))
		{
			com.sendRequest(operande1, operande2, this.operation);
			op1 = null;
			op2 = null;
			req = null;
		}
		else
			this.operation = operation;
		
		informer();
	}
	
	public String getRequest()
	{
		StringBuilder sb = new StringBuilder();
		
		if(op1 != null)
		{
			sb.append(op1).append(" ");
			if(req != null)
			{
				sb.append(req).append(" ");
				if(op2 != null)
				{
					sb.append(op2);
				}
			}
		}
		
		return sb.toString();
	}
	
	/*---------------------------------------------------------------*/
	/**
	 * @param arg0
	 * @param arg1
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1)
	{
		if(arg0 instanceof CommunicationService)
		{
			if(arg1 instanceof RequestOperation)
			{
				RequestOperation req = (RequestOperation)arg1;
				mdlResult.addResult(req.toString());
			}
		}
		else
			informer();
	}
	
	private void informer()
	{
		setChanged();
		notifyObservers();
	}

	/*---------------------------------------------------------------*/
	/**
	 * @return
	 */
	public ListModel getModelList()
	{
		return mdlResult;
	}

}


/*---------------------------------------------------------------*/
/* Fin du fichier Model.java
/*---------------------------------------------------------------*/