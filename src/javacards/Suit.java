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
     * 1 = Heart, 2 = Clubs, 3 = Diamonds, 4 = Spades, 5 = Doves, 6 = Axes, 7 = Roses, 8 = Tridents
     * @return
     */
    public static int toInt(Suit suit)
    {
    	switch(suit)
    	{
    		case HEARTS: 
    			return 1;
    		case CLUBS: 
    			return 2;
    		case DIAMONDS:
				return 3;
    		case SPADES:
    			return 4;
    		case DOVES:
    			return 5;
    		case AXES:
    			return 6;
    		case ROSES:
    			return 7;
    		default:
    			return 8;
    	}
    }
    
}
