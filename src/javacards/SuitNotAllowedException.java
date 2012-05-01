package javacards;

/**
 * An exception class that is usually thrown if the suit given doesn't exist
 * @author PatrickRose - pjr0911025@googlemail.com
 */
class SuitNotAllowedException extends Exception {

    /**
	 * The serial version UID. I have no idea what the fuck this is for, but Eclipse 
	 * wouldn't shut up.
	 */
	private static final long serialVersionUID = -5420827606773600192L;

	public SuitNotAllowedException(int s) {
        super("Bad suit given: " + s);
    }
    
}
