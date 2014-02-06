/*---------------------------------------------------------------*/
/**
 * Fichier : ProtocolCommandes.java
 * 
 * créé le 23 janv. 2014 à 08:35:13
 * 
 * Auteurs : Léo Riera & Vincent Voyer
 */
package services;

/*---------------------------------------------------------------*/
/**
 * The Enum ProtocolCommandes.
 * 
 * @author vivoyer
 */
public enum ProtocolCommandes
{
	/** The add. */
	ADD("ADD"),
	/** The div. */
	DIV("DIV"),
	/** The min. */
	MIN("MIN"),
	/** The mul. */
	MUL("MUL"),
	/** The O p1. */
	OP1("OP1"),
	/** The O p2. */
	OP2("OP2"),
	/** The quit. */
	QUIT("QUIT"),
	/** The req. */
	REQ("REQ"),
	/** The res. */
	RES("RES"),
	/** The sep. */
	SEP(" "),
	/** The stat. */
	STAT("STAT"),
	/** The tim. */
	TIM("TIM");
	/** The value. */
	private final String	value;

	/**
	 * Instantiates a new protocol commandes.
	 * 
	 * @param value
	 *            the value
	 */
	private ProtocolCommandes(final String value)
	{
		this.value = value;
	}

	/*---------------------------------------------------------------*/
	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString()
	{
		return value;
	}
}
/*---------------------------------------------------------------*/
/*
 * Fin du fichier ProtocolCommandes.java
 * /*---------------------------------------------------------------
 */
