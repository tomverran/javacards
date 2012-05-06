package javacards;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A class which represents a deck of cards
 * @author PatrickRose - pjr0911025@googlemail.com
 */
public class Deck {
    
    /**
     * Represents the deck
     */
    private ArrayList<Card> deck;
    
    /**
     * Creates a 4 suited deck
     */
    public Deck()
    {
        this(4);
    }
    
    /**
     * Creates a deck of cards
     * @param numOfSuits How many suits in the deck
     */
    public Deck (int numOfSuits)
    {
        deck = new ArrayList<Card>();
        for (int i=1; i<=numOfSuits; i++)
        {
            for (int j=1; j<=13; j++)
            {
                try {
                    deck.add(new Card(i, j));
                } catch (Exception ex) {
                    System.exit(0);
                    //TODO: Sort out exception handling so it doesn't just crash
                }
            }
        }
    }
    
    /**
     * Checks to see if the deck is sorted or not. Note that the deck doesn't
     * care about duplicate or missing cards. Two aces of spades next to each
     * other followed by a 5 of spades will count as sorted
     * @return True if the deck is in sorted order, otherwise false
     */
    public boolean isSorted()
    {
        for (int i=0; i<(deck.size()-1); i++)
        {
            if (deck.get(i).compareTo(deck.get(i+1)) == 1)
            {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Sorts the deck
     */
    public void sortDeck()
    {
        Collections.sort(deck);
    }
    
    /**
     * Shuffles the cards
     */
    public void shuffleDeck ()
    {
    	Collections.shuffle(deck);
    }

    @Override
    public String toString()
    {
        StringBuilder toReturn = new StringBuilder();
        for(int i=0; i < deck.size()-1; i++)
        {
            toReturn.append(deck.get(i)).append(", ");
        }
        toReturn.append(deck.get(deck.size()-1));
        return toReturn.toString();
    }
    
    /**
     * Adds a card to the bottom of deck.
     * @param toAdd The card to add to the deck
     */
    public void addCard(Card toAdd)
    {
        deck.add(toAdd);
    }
    
    /**
     * Adds a card to either the top or bottom of the deck.
     * @param toAdd The card to add to the deck
     * @param front Whether to put it at the front of back of the deck. True is 
     * at the front
     */
    public void addCard(Card toAdd, boolean front)
    {
        if (front)
        {
            deck.add(0, toAdd);
        }
        else
        {
            deck.add(toAdd);
        }
    }
    
    /**
     * Removes the card at the top of the deck and returns it
     * @return The top card of the deck
     */
    public Card drawCard()
    {
        Card toReturn = deck.get(0);
        deck.remove(0);
        return toReturn;
    }
    
    /**
     * Returns the size of the deck.
     * @return The size of the deck.
     */
    public int size()
    {
        return deck.size();
    }
    
    /**
     * Removes all cards of that suit from the deck
     * @param suit 
     */
    public void removeSuit(Suit suitToRemove)
    {
        int i=0;
        while(i<deck.size())
        {
            if(deck.get(i).getSuit() == suitToRemove)
            {
                deck.remove(i);
            }
            else
            {
                i++;
            }
        }
    }
    
    /**
     * Returns the top card of the deck
     * @return The top card of the deck
     */
    public Card getTopCard()
    {
    	return deck.get(0);
    }

    /**
     * Places a card at position x. NOTE THAT THE FIRST POSITION IS 1
     * @param position Position to add the card at
     * @param toAdd The card to add
     */
    public void placeAtX(int position, Card toAdd)
    {
    	deck.add(position-1, toAdd);
    }
    
    /**
     * Places a card in a random position in the deck
     * @param toAdd The card to add
     */
    public void placeRandom(Card toAdd)
    {
    	placeAtX((int)Math.random()*(deck.size()), toAdd);
    }
    
    /**
     * Returns the card from the bottom of the deck
     * @return The card at the bottom of the deck
     */
    public Card getBottomCard()
    {
    	return deck.get(deck.size()-1);
    }
    
    /**
     * Gets the card at a specified position position. NOTE THAT THE FIRST POSITION IS 1.
     * @param position The position of the card to look at
     * @return The card at position.
     */
    public Card getCardAtX(int position) throws IndexOutOfBoundsException
    {
    	return deck.get(position-1);
    }
    
    /**
     * Gets a set of cards from the top of the deck
     * @param numberToGet The number of cards to get from the top of the deck
     * @return A certain number of cards from the deck
     * @throws IndexOutOfBoundsException If numberToGet isn't between 0 and the size of the deck
     */
    public ArrayList<Card> getCards(int numberToGet)
    {
        if (numberToGet < 0) throw new IndexOutOfBoundsException();
        return new ArrayList<Card>(deck.subList(0, numberToGet));
    }
    
    /**
     * Gets a set of card from a specified place in the deck
     * @param numberToGet The number of cards to return 
     * @param startPosition Where to start taking the cards from. NOTE THAT THE
     * FIRST POSITION IS 1.
     * @return A number of cards from the deck
     * @throws IndexOutOfBoundsException If the numberToGet is less than 0
     */
    public ArrayList<Card> getCards(int numberToGet, int startPosition)
    {
        if (numberToGet < 0) throw new IndexOutOfBoundsException();   
        return new ArrayList<Card>(deck.subList(startPosition-1, numberToGet));       
    }
    
    /**
     * Gets the cards at the bottom of the deck
     * @param amount The number of cards to get
     * @return The cards at the bottom of the deck
     * @throws IndexOutOfBoundsException If amount is less than 0
     */
    public ArrayList<Card> getBottomCards(int amount)
    {
        if (amount < 0) throw new IndexOutOfBoundsException();
        int size = deck.size();
        return new ArrayList<Card>(deck.subList(size-amount, size-1)); 
    }

    /**
     * Removes all cards of a certain rank from the deck.
     * @param rankToRemove The rank of the card to be removed.
     */
    public void removeRank(int rankToRemove) 
    {
        int i=0;
        while(i<deck.size())
        {
            if(deck.get(i).getRank() == rankToRemove)
            {
                deck.remove(i);
            }
            else
            {
                i++;
            }
        }
    }

    /**
     * Tests if the deck is empty or not
     * @return True if there are no cards in the deck, false otherwise
     */
    public boolean isEmpty() 
    {
        return deck.isEmpty();
    }
}