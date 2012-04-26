package lostcities;

import javacards.Suit;

public class BadSuitPlayedException extends Exception {

	/**
	 * Eclipse just wanted this.
	 */
	private static final long serialVersionUID = 4229690975566721762L;

	public BadSuitPlayedException(Suit suitPlayed, Suit deckOfSuit)
	{
		super("Bad suit played. The suit they tried to play was " + suitPlayed + ", and the suit needed was " + deckOfSuit);
	}

}
