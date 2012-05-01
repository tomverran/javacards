/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacards;

/**
 * The various suits of the deck. This is the 8 suited version, containing
 * diamonds, hearts, clubs, spades, tridents, roses, doves and axes
 * @author paddy
 */
public enum Suit {
    
    DIAMONDS, HEARTS, CLUBS, SPADES, TRIDENTS, ROSES, DOVES, AXES;
    
    /**
     * Value used for hearts
     */
    public static final int HEART = 1;
    /**
     * Value used for clubs
     */
    public static final int CLUB = 2;
    /**
     * Value used for diamonds
     */
    public static final int DIAMOND = 3;
    /**
     * Value used for spades
     */
    public static final int SPADE = 4;
    /**
     * Value used for doves
     */
    public static final int DOVE = 5;
    /**
     * Value used for axes
     */
    public static final int AXE = 6;
    /**
     * Value used for roses
     */
    public static final int ROSE = 7;
    /**
     * Value used for tridents
     */
    public static final int TRIDENT = 8;

    
    /**
     * 1 = Heart, 2 = Clubs, 3 = Diamonds, 4 = Spades, 5 = Doves, 6 = Axes, 7 = Roses, 8 = Tridents
     * @return
     */
    public static int toInt(Suit suit)
    {
    	switch(suit)
    	{
    		case HEARTS: 
    			return HEART;
    		case CLUBS: 
    			return CLUB;
    		case DIAMONDS:
				return DIAMOND;
    		case SPADES:
    			return SPADE;
    		case DOVES:
    			return DOVE;
    		case AXES:
    			return AXE;
    		case ROSES:
    			return ROSE;
    		default:
    			return TRIDENT;
    		//TODO: This should probably have a fail condition that throws
    	}
    }
    
}
