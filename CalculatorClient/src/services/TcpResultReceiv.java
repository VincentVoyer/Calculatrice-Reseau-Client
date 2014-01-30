/**
 * 
 */
package services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @author Vincent
 * @date 30 janv. 2014
 */
public class TcpResultReceiv extends ResultReceiv {

	public TcpResultReceiv(Socket soc)
	{
		super(soc);
	}

	/* (non-Javadoc)
	 * @see services.ResultReceiv#receiv()
	 */
	@Override
	public void receiv() {
		String message;
		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in));
		BufferedReader inFromServer;
		try {
			inFromServer = new BufferedReader(new InputStreamReader(resultSoc.getInputStream()));
			message = inFromServer.readLine();
			if(message != null)
				analyze(message);
		} catch (IOException e) {
		}
	}

	private void analyze(String message)
	{
		String[] args = message.split(ProtocolCommandes.SEP.toString());

		try
		{
			if(args[1].equals(ProtocolCommandes.RES.toString()))
			{
				idRequest = Integer.parseInt(args[0]);
				result = Float.parseFloat(args[2]);
				informer();
			}
		}
		catch(Exception e)
		{
		}
	}
}
