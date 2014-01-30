/**
 * 
 */
package services;

import services.ProtocolCommandes.*;

/**
 * @author Vincent
 * @date 30 janv. 2014
 */
public class RequestOperation {
	private float op1;
	
	private float op2;
	
	private String operation;
	
	private float result;
	
	public RequestOperation(float op1, float op2 , String operation)
	{
		this.op1 = op1;
		this.op2 = op2;
		this.operation = operation;
	}
	
	public void addResultat(float resultat)
	{
		result = resultat;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(op1);
		switch (operation)
		{
			case "ADD":
				sb.append(" + ");
				break;
			case "MIN":
				sb.append(" - ");
				break;
			case "MUL":
				sb.append(" * ");
				break;
			case "DIV":
				sb.append(" / ");
				break;
		}
		sb.append(op2);
		sb.append(" = ");
		sb.append(result);

		return sb.toString();
	}
}
