package lostcities;

import javacards.Card;
import java.util.ArrayList;

public class NotInHandException extends Exception {

	/**
	 * Eclipse complains if this isn't here...
	 */
	private static final long serialVersionUID = 6293758643245465840L;
	
	public NotInHandException(Card card, ArrayList<Card> hand)
	{
		super("The card given was not in the hand. Card was " + card + " and hand was " + hand);
	}

}
