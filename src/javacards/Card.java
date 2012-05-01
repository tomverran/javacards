/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacards;

/**
 * 
 * @author paddy
 */
public class Card implements Comparable<Card>
{
    
    /**
     * The rank of the card. Ace = 1, Jack = 11, Queen = 12, King = 13.
     */
    private int rank;
    
    /**
     * The suit of the card
     */
    private Suit suit;
    
    /**
     * Whether the card is on its back or not. True if the card is face
     * down, false otherwise
     */
    boolean isFlipped = false;
    
    /**
     * Creates a randomly generated card
     * @throws SuitNotAllowedException If the suit generated isn't between 1 and 8
     */
    public Card() throws SuitNotAllowedException
    {
        rank = (int)Math.random()*13+1;
        int suitRandom = (int)Math.random()*8+1;
        switch (suitRandom)
        {
            case Suit.HEART:
                suit = Suit.HEARTS;
                break;
            case Suit.CLUB:
                suit = Suit.CLUBS;
                break;
            case Suit.DIAMOND:
                suit = Suit.DIAMONDS;
                break;
            case Suit.SPADE:
                suit = Suit.SPADES;
                break;
            case Suit.DOVE: 
                suit = Suit.DOVES;
                break;
            case Suit.AXE:
                suit = Suit.AXES;
                break;
            case Suit.ROSE:
                suit = Suit.ROSES;
                break;
            case Suit.TRIDENT:
            	suit = Suit.TRIDENTS;
            default:
                // We should never hit this case, but if any future
                // work introduces an error, we should fail consistently.
                throw new SuitNotAllowedException(suitRandom);
        }       
    }
    
    /**
     * Creates a random card from the given suit
     * @param s The suit of the new card
     */
    public Card(Suit s)
    {
        rank = (int)Math.random()*13+1;
        suit = s;
    }
    
    /**
     * Creates a new card
     * @param r The rank for the card to be made (Ace = 1, King = 12)
     * @param s The suit for the card. 1 = Heart, 2 = Clubs, 3 = Diamonds, 4
     * = Spades, 5 = Doves, 6 = Axes, 7 = Roses, 8 = Tridents
     * @throws RankNotAllowedException If the rank given isn't between 1 and 13
     * @throws SuitNotAllowedException If the suit given isn't between 1 and 8
     */
    public Card(int s, int r) throws RankNotAllowedException, SuitNotAllowedException
    {
        if (r<1 || r>13)
        {
            throw new RankNotAllowedException(r);
        }
        rank = r;
        switch(s)
        {
            case Suit.HEART:
                suit = Suit.HEARTS;
                break;
            case Suit.CLUB:
                suit = Suit.CLUBS;
                break;
            case Suit.DIAMOND:
                suit = Suit.DIAMONDS;
                break;
            case Suit.SPADE:
                suit = Suit.SPADES;
                break;
            case Suit.DOVE: 
                suit = Suit.DOVES;
                break;
            case Suit.AXE:
                suit = Suit.AXES;
                break;
            case Suit.ROSE:
                suit = Suit.ROSES;
                break;
            case Suit.TRIDENT:
                suit = Suit.TRIDENTS; 
                break;
            default:
                throw new SuitNotAllowedException(s);
        }
    }
    
    /**
     * Creates a new card with a specified suit and rank
     * @param s The suit of the new card
     * @param r The rank of the new card
     * @throws RankNotAllowedException If the rank given is not between 1 and 13
     */
    public Card(Suit s, int r) throws RankNotAllowedException
    {
        if (r<1 || r>13)
        {
            throw new RankNotAllowedException(r);
        }
        rank = r;
        suit = s;
    }
    
    /**
     * @return The rank of the card
     */
    public int getRank()
    {
        return rank;
    }
    
    /**
     * Returns whether the card is on it's back or not
     * @return True if the card is face down, false otherwise.
     */
    public boolean isFlipped()
    {
    	return isFlipped;
    }
    
    /**
     * Changes which side of the card is up.
     */
    public void flipCard()
    {
    	isFlipped = !isFlipped;
    }
    
    /**
     * @return The suit of the card
     */
    public Suit getSuit()
    {
        return suit;
    }
    
    public boolean equals(Card e)
    {
        return (e.getRank() == rank && e.getSuit() == suit);
    }
    
    @Override 
    public String toString()
    {
        String rankString;
        switch (rank)
        {
            case 1:
                rankString = "Ace";
                break;
            case 11:
                rankString = "Jack";
                break;
            case 12:
                rankString = "Queen";
                break;
            case 13:
                rankString = "King";
                break;
            default:
                rankString = "" + rank;
        }
        return (suit.toString() + ":" + rankString);
    }
    
	@Override
	public int compareTo(Card toCompare) 
	{
	    final int BEFORE = -1;
	    final int EQUAL = 0;
	    final int AFTER = 1;
	    if (toCompare == this)
	    {
	    	return EQUAL;
	    }
	    int compareSuit = Suit.toInt(toCompare.getSuit());
	    int thisSuit = Suit.toInt(suit);
    	if (compareSuit != thisSuit)
	    {
	    	if (compareSuit < thisSuit)
	    	{
	    		return BEFORE;
	    	}
	    	else
	    	{
	    		return AFTER;
	    	}
	    }
	    int compareRank = toCompare.getRank();
	    if (compareRank != rank)
	    {
	    	if (compareRank < rank)
	    	{
	    		return BEFORE;
	    	}
	    	else
	    	{
	    		return AFTER;
	    	}
	    }
	    return 0;
	}
    
}
