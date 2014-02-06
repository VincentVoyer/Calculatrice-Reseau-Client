/**
 * 
 */
package services;

/**
 * The Class RequestOperation.
 * 
 * @author Vincent
 * @date 30 janv. 2014
 */
public class RequestOperation
{
	/** The op1. */
	private final float		op1;
	/** The op2. */
	private final float		op2;
	/** The operation. */
	private final String	operation;
	/** The result. */
	private float			result;

	/**
	 * Instantiates a new request operation.
	 * 
	 * @param op1
	 *            the op1
	 * @param op2
	 *            the op2
	 * @param operation
	 *            the operation
	 */
	public RequestOperation(final float op1, final float op2,
			final String operation)
	{
		this.op1 = op1;
		this.op2 = op2;
		this.operation = operation;
	}

	/**
	 * Adds the resultat.
	 * 
	 * @param resultat
	 *            the resultat
	 */
	public void addResultat(final float resultat)
	{
		result = resultat;
	}

	/* _________________________________________________________ */
	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder();
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
			default:
				break;
		}
		sb.append(op2);
		sb.append(" = ");
		sb.append(result);
		return sb.toString();
	}
}
