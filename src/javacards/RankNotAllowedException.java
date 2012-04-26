/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacards;

/**
 *
 * @author paddy
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
