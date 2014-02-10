package services;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * The Class TcpRequestSender.
 */
public class TcpRequestSender implements RequestSender
{
	/** The sender soc. */
	private final Socket	senderSoc;

	/**
	 * Instantiates a new tcp request sender.
	 * 
	 * @param soc
	 *            the soc
	 */
	public TcpRequestSender(final Socket soc)
	{
		senderSoc = soc;
	}

	/* _________________________________________________________ */
	/**
	 * Send request.
	 * 
	 * @param id
	 *            the id
	 * @param op1
	 *            the op1
	 * @param op2
	 *            the op2
	 * @param operation
	 *            the operation
	 * @see services.RequestSender#sendRequest(int, float, float,
	 *      java.lang.String)
	 */
	@Override
	public void sendRequest(final int id, final float op1, final float op2,
			final String operation)
	{
		final StringBuilder sb = new StringBuilder();
		sb.append(id).append(ProtocolCommandes.SEP.toString())
				.append(operation).append(ProtocolCommandes.SEP.toString())
				.append(ProtocolCommandes.OP1.toString())
				.append(ProtocolCommandes.SEP.toString()).append(op1)
				.append(ProtocolCommandes.SEP.toString())
				.append(ProtocolCommandes.OP2.toString())
				.append(ProtocolCommandes.SEP.toString()).append(op2);
		send(sb.toString() + '\n');
	}

	/**
	 * Send.
	 * 
	 * @param string
	 *            the string
	 */
	private void send(final String string)
	{
		try
		{
			final DataOutputStream outToServer = new DataOutputStream(
					senderSoc.getOutputStream());
			outToServer.writeBytes(string);
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
	}

	/* _________________________________________________________ */
	/**
	 * Send request stat.
	 * 
	 * @see services.RequestSender#sendRequestStat()
	 */
	@Override
	public void sendRequestStat()
	{
		send(ProtocolCommandes.STAT.toString() + '\n');
	}
}
