package services;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class CommunicationService extends Observable implements Observer {
	
	private int nbRequest = 0;
	
	private RequestSender request;
	
	private ResultReceiv receiver;
	
	private Map<Integer, RequestOperation> requestOperations;
	
	private int port = 5042;

	public CommunicationService() throws UnknownHostException, IOException
	{
		Socket soc = new Socket("localhost", port);
		
		request = new TcpRequestSender(soc);
		receiver = new TcpResultReceiv(soc);
		
		requestOperations = new HashMap<Integer, RequestOperation>();
		
		receiver.addObserver(this);
		Thread th = new Thread(receiver);
		th.setDaemon(true);
		th.start();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof ResultReceiv)
		{
			RequestOperation req = requestOperations.get(receiver.getIdRequest());
			if(req != null)
			{
				req.addResultat(receiver.getResulat());
				informer(req);
			}
		}
	}
	
	public void sendRequest(float op1, float op2, String operation){
		requestOperations.put(nbRequest, new RequestOperation(op1, op2, operation));
		request.sendRequest(nbRequest,op1, op2, operation);
		nbRequest++;
	}
	
	private void informer(Object obj)
	{
		setChanged();
		notifyObservers(obj);
	}
}
