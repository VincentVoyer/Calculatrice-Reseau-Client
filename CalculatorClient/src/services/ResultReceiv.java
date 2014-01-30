/**
 * 
 */
package services;

import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

/**
 * @author Vincent
 * @date 30 janv. 2014
 */
public abstract class ResultReceiv extends Observable implements Runnable {
	
	protected int idRequest;
	
	protected float result;
	
	protected Socket resultSoc;
	
	public ResultReceiv(Socket soc)
	{
		resultSoc = soc;
	}
	
	public int getIdRequest()
	{
		return idRequest;
	}
	
	public float getResulat()
	{
		return result;
	}
	
	public abstract void receiv();
	
	@Override
	public void run() {
		while(resultSoc.isConnected())
		{
			receiv();
		}
		try {
			resultSoc.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void informer()
	{
		setChanged();
		notifyObservers();
	}
}
