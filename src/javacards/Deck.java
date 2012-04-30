/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacards;

import java.util.ArrayList;

/**
 * A class which represents a deck of cards
 * @author paddy
 */
public class Deck {
    
    private ArrayList<Card> deck;
    
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
                    //TODO: Sort out exception handling so it doesn't just crash - unsure how?
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
        int lastValue=0;
        for (int i=0; i<deck.size(); i++)
        {
            if (deck.get(i).value()<lastValue)
            {
                return false;
            }
            else
            {
                lastValue = deck.get(i).value();
            }
        }
        return true;
    }
    
    /**
     * Sorts the deck
     */
    public void sortDeck()
    {
    	//TODO: Use comparable feature of Card.
        ArrayList<Card> toReturn = new ArrayList<Card>();
        toReturn.add(deck.get(0));
        for (int i=1; i<deck.size(); i++)
        {
            Card putInPlace = deck.get(0);
            int j=0;
            while ((putInPlace.value() < toReturn.get(j).value()) && i<toReturn.size())
            {
                i++;
            }
            toReturn.add(i, putInPlace);
        }
        deck = toReturn;
    }
    
    /**
     * Shuffles the cards
     */
    public void shuffleDeck()
    {
        ArrayList<Card> toReturn = new ArrayList<Card>();
        while(!deck.isEmpty())
        {
            int randomNumber = (int)(Math.random()*deck.size());
            toReturn.add(deck.get(randomNumber));
            deck.remove(randomNumber);
        }
        deck = toReturn;
    }
    
    @Override
    public String toString()
    {
        String toReturn = "";
        for(int i=0; i<deck.size()-1; i++)
        {
            toReturn = toReturn + deck.get(i) + ", ";
        }
        toReturn = toReturn + deck.get(deck.size());
        return toReturn;
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
    public ArrayList<Card> getCards(int numberToGet) throws IndexOutOfBoundsException
    {
    	if (numberToGet<0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	ArrayList<Card> toReturn = new ArrayList<Card>();
    	for(int i=0; i<numberToGet; i++)
    	{
    		toReturn.add(deck.get(i));
    	}
    	return toReturn;
    }
    
    /**
     * Gets a set of card from a specified place in the deck
     * @param numberToGet The number of cards to return 
     * @param startPosition Where to start taking the cards from. NOTE THAT THE
     * FIRST POSITION IS 1.
     * @return A number of cards from the deck
     * @throws IndexOutOfBoundsException If the numberToGet is less than 0
     */
    public ArrayList<Card> getCards(int numberToGet, int startPosition) throws IndexOutOfBoundsException
    {
    	if (numberToGet<0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	ArrayList<Card> toReturn = new ArrayList<Card>();
    	for(int i=0; i<numberToGet; i++)
    	{
    		toReturn.add(deck.get(i+(startPosition-1)));
    	}
    	return toReturn;
    }
    
    /**
     * Gets the cards at the bottom of the deck
     * @param amount The number of cards to get
     * @return The cards at the bottom of the deck
     * @throws IndexOutOfBoundsException If amount is less than 0
     */
    public ArrayList<Card> getBottomCards(int amount) throws IndexOutOfBoundsException
    {
    	if (amount<0)
    	{
    		throw new IndexOutOfBoundsException();
    	}
    	ArrayList<Card> toReturn = new ArrayList<Card>();
    	for (int i=1; i<=amount; i++)
    	{
    		toReturn.add(0, deck.get(deck.size()-i));
    	}
    	return toReturn;
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

    public boolean isEmpty() {
        return deck.isEmpty();
    }
    
}