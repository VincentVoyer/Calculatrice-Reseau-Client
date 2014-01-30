/**
 * 
 */
package services;

/**
 * @author Vincent
 * @date 30 janv. 2014
 */
public interface RequestSender {
	
	public void sendRequest(int id, float op1, float op2 , String operation);
}
