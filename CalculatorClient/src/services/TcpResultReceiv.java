/**
 * 
 */
package services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Observer;

/**
 * The Class TcpResultReceiv.
 * 
 * @author Vincent
 * @date 30 janv. 2014
 */
public class TcpResultReceiv extends ResultReceiv
{
	/**
	 * Instantiates a new tcp result receiv.
	 * 
	 * @param soc
	 *            the soc
	 */
	public TcpResultReceiv(final Socket soc)
	{
		super(soc);
	}

	/* _________________________________________________________ */
	/**
	 * Adds the observer.
	 * 
	 * @param o
	 *            the o
	 * @see java.util.Observable#addObserver(java.util.Observer)
	 */
	@Override
	public synchronized void addObserver(final Observer o)
	{
		super.addObserver(o);
	}

	/**
	 * Analyze.
	 * 
	 * @param message
	 *            the message
	 */
	private void analyze(final String message)
	{
		final String[] args = message.split(ProtocolCommandes.SEP.toString());
		try
		{
			if (args[1].equals(ProtocolCommandes.RES.toString()))
			{
				idRequest = Integer.parseInt(args[0]);
				result = Float.parseFloat(args[2]);
				informer();
			}
		}
		catch (final Exception e)
		{
		}
	}

	/*
	 * (non-Javadoc)
	 * @see services.ResultReceiv#receiv()
	 */
	/* _________________________________________________________ */
	/**
	 * @see services.ResultReceiv#receiv()
	 */
	@Override
	public void receiv()
	{
		String message;
		BufferedReader inFromServer;
		try
		{
			inFromServer = new BufferedReader(new InputStreamReader(
					resultSoc.getInputStream()));
			message = inFromServer.readLine();
			if (message != null)
			{
				analyze(message);
			}
		}
		catch (final IOException e)
		{
		}
	}
}
