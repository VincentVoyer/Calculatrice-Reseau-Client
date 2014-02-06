/**
 * 
 */
package services;

// TODO: Auto-generated Javadoc
/**
 * The Interface RequestSender.
 * 
 * @author Vincent
 * @date 30 janv. 2014
 */
public interface RequestSender
{
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
	 */
	public void sendRequest(int id, float op1, float op2, String operation);
}
