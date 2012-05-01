package javacards;

/**
 * An exception that's thrown if a rank isn't between 1 - 13.
 * @author PatrickRose - pjr0911025@googlemail.com
 */
class RankNotAllowedException extends Exception {

    /**
	 * The serial version UID. I have no idea what the fuck this is for, but Eclipse 
	 * wouldn't shut up.
	 */
	private static final long serialVersionUID = 1217234111056553732L;

	public RankNotAllowedException(int r) {
        super("Bad card rank: " + r);
    } 
    
}
