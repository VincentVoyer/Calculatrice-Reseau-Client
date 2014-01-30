package services;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TcpRequestSender implements RequestSender {

	private Socket senderSoc;
	
	public TcpRequestSender(Socket soc)
	{
		senderSoc = soc;
	}
	
	@Override
	public void sendRequest(int id,float op1, float op2, String operation) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(id)
			.append(ProtocolCommandes.SEP.toString())
			.append(operation)
			.append(ProtocolCommandes.SEP.toString())
			.append(ProtocolCommandes.OP1.toString())
			.append(ProtocolCommandes.SEP.toString())
			.append(op1)
			.append(ProtocolCommandes.SEP.toString())
			.append(ProtocolCommandes.OP2.toString())
			.append(ProtocolCommandes.SEP.toString())
			.append(op2);
		
		
		try {
			DataOutputStream outToServer = new DataOutputStream(senderSoc.getOutputStream());
			outToServer.writeBytes(sb.toString() + '\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
