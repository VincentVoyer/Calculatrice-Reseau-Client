package services;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * The Class CommunicationService.
 */
public class CommunicationService extends Observable implements Observer
{
	/** The nb request. */
	private int										nbRequest	= 0;
	/** The port. */
	private int										port		= 5042;
	/** The receiver. */
	private final ResultReceiv						receiver;
	/** The request. */
	private final RequestSender						request;
	/** The request operations. */
	private final Map<Integer, RequestOperation>	requestOperations;
	/** The soc. */
	private final Socket							soc;

	/**
	 * Instantiates a new communication service.
	 * 
	 * @param port
	 *            the port
	 * @throws UnknownHostException
	 *             the unknown host exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public CommunicationService(final int port) throws UnknownHostException,
			IOException
	{
		this.port = port;
		soc = new Socket("localhost", port);
		request = new TcpRequestSender(soc);
		receiver = new TcpResultReceiv(soc);
		requestOperations = new HashMap<>();
		receiver.addObserver(this);
		final Thread th = new Thread(receiver);
		th.setDaemon(true);
		th.start();
	}

	/**
	 * Informer.
	 * 
	 * @param obj
	 *            the obj
	 */
	private void informer(final Object obj)
	{
		setChanged();
		notifyObservers(obj);
	}

	/**
	 * Send request.
	 * 
	 * @param op1
	 *            the op1
	 * @param op2
	 *            the op2
	 * @param operation
	 *            the operation
	 */
	public void sendRequest(final float op1, final float op2,
			final String operation)
	{
		requestOperations.put(nbRequest, new RequestOperation(op1, op2,
				operation));
		request.sendRequest(nbRequest, op1, op2, operation);
		nbRequest++;
	}

	/* _________________________________________________________ */
	/**
	 * Update.
	 * 
	 * @param observable
	 *            the arg0
	 * @param object
	 *            the arg1
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(final Observable observable, final Object object)
	{
		if (observable instanceof ResultReceiv)
		{
			if (object == null)
			{
				final RequestOperation req = requestOperations.get(receiver
						.getIdRequest());
				if (req != null)
				{
					req.addResultat(receiver.getResulat());
					informer(req);
				}
			}
			else if (object instanceof String)
			{
				informer(object);
			}
		}
	}

	/*
	 * _________________________________________________________
	 */
	/**
	 * Send request stat.
	 */
	public void sendRequestStat()
	{
		request.sendRequestStat();
	}

	/* _________________________________________________________ */
	/**
	 * Retourne la valeur du champ port.
	 * 
	 * @return la valeur du champ port.
	 */
	public int getPort()
	{
		return port;
	}

	/* _________________________________________________________ */
	/**
	 * Modifie la valeur du cmap port.
	 * 
	 * @param port
	 *            la valeur à placer dans le champ port.
	 */
	public void setPort(final int port)
	{
		this.port = port;
	}
}
