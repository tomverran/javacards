/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacards;

/**
 *
 * @author paddy
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
