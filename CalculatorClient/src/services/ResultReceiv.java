/**
 * 
 */
package services;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

/**
 * The Class ResultReceiv.
 * 
 * @author Vincent
 * @date 30 janv. 2014
 */
public abstract class ResultReceiv extends Observable implements Runnable
{
	/** The id request. */
	protected int		idRequest;
	/** The result. */
	protected float		result;
	/** The result soc. */
	protected Socket	resultSoc;

	/**
	 * Instantiates a new result receiv.
	 * 
	 * @param soc
	 *            the soc
	 */
	public ResultReceiv(final Socket soc)
	{
		resultSoc = soc;
	}

	/**
	 * Gets the id request.
	 * 
	 * @return the id request
	 */
	public int getIdRequest()
	{
		return idRequest;
	}

	/**
	 * Gets the resulat.
	 * 
	 * @return the resulat
	 */
	public float getResulat()
	{
		return result;
	}

	/**
	 * Informer.
	 */
	protected void informer()
	{
		setChanged();
		notifyObservers();
	}

	/**
	 * Receiv.
	 */
	public abstract void receiv();

	/* _________________________________________________________ */
	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while (resultSoc.isConnected())
		{
			receiv();
		}
		try
		{
			resultSoc.close();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}
}
