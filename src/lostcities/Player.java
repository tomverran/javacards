/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lostcities;

import java.util.ArrayList;
import javacards.*;

/**
 * 
 * @author paddy
 */
abstract class Player 
{    
    /**
     * The player's hand.
     */
    private ArrayList<Card> hand = new ArrayList<Card>();
    
    /**
     * The expeditions on the table. 0 = Heart, 1 = Clubs, 2 = Diamonds, 3 = Spades, 4 = Doves
     */
    private Deck[] expeditions = new Deck[5];
    
    /**
     * The player's name
     */
    private String name;
    
    /**
     * Creates a new instance of player
     * @param n The name of the player
     */
    public Player(String n)
    {
        name = n;
        for (@SuppressWarnings("unused") Deck current : expeditions) 
        {
            current = new Deck(0);
        }
    }
    
    /**
     * Draws a card from the specified deck and adds it to the player's hand.
     * @param toDrawFrom The deck to draw from.
     */
    public void drawFromDeck(Deck toDrawFrom)
    {
        hand.add(toDrawFrom.drawCard());
        Deck temp = new Deck(0);
        while (!hand.isEmpty())
        {
        	Card toAdd = hand.get(0);
        	hand.remove(0);
        	temp.addCard(toAdd);
        }
        temp.sortDeck();
        while (!temp.isEmpty())
        {
        	hand.add(temp.drawCard());
        }
    }
    
    public abstract Deck getDeckToDrawFrom(GameState gamestate);
    
    /**
     * Plays a card on to a specified deck
     * @param toPlay
     * @param toPlayOn
     * @throws NotInHandException
     * @throws BadSuitPlayedException
     */
    public void playACard(Card toPlay, Deck toPlayOn) throws NotInHandException, BadSuitPlayedException
    {
    	if (hand.indexOf(toPlay) == -1)
    	{
    		throw new NotInHandException(toPlay, hand);
    	}
    	if (toPlay.getSuit() != toPlayOn.getTopCard().getSuit())
    	{
    		throw new BadSuitPlayedException(toPlay.getSuit(), toPlayOn.getTopCard().getSuit());
    	}
    	hand.remove(toPlay);
    	toPlayOn.addCard(toPlay, true);
    }
    
    /**
     * Chooses a card from the hand to play.
     * @return A pair, containing a card and a deck
     */
    public abstract Pair<Card, Deck> chooseACardToPlay(GameState gameState);
    
    
    /**
     * Returns the player's current score
     * @return The player's current score.
     */
    public int getScore()
    {
        int toReturn = 0;
        for (Deck current : expeditions) 
        {
            toReturn += scoreExpedition(current);
        }
        return toReturn;
    }
    
    /**
     * Scores the given expedition. The rules are: If there is a card in the pile, then the base score is -20.
     * We then add each of the values of the cards, except for J/Q/K. Each J/Q/K increases the multiplier of 
     * the expedition by 1. If there are 8 or more cards in the expedition then there is a bonus of 20 points
     * The basic formula is score = (sumOfValues - 20) * (number of J/Q/K + 1) + (20 * numberOfCards DIV 8)
     * @param toScore The expedition to score
     * @return The score of that expedition.
     */
    private int scoreExpedition(Deck toScore)
    {
        boolean bonus = toScore.size() >= 8;
        int toReturn;
        if (toScore.isEmpty())
		{
        	toReturn = 0;
    	}
        else
        {
        	toReturn = -20;
        }
        int currentMultiplier = 1;
        while (!toScore.isEmpty())
        {
            Card currentCard = toScore.drawCard();
            if(currentCard.getRank()>10)
            {
                currentMultiplier++;
            }
            else
            {
                toReturn += currentCard.getRank();
            }
        }
        toReturn *= currentMultiplier;
        if (bonus)
        {
            toReturn += 20;
        }
        return toReturn;
    }
    
    /**
     * Returns the player's current hand.
     * @return The player's current hand.
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    
    /**
     * Returns the current expeditions.
     * @return The expeditions.
     */
    public Deck[] getExpeditions()
    {
        return expeditions;
    }
    
    /**
     * Return's the player's name.
     * @return The player's name.
     */
    public String getName()
    {
    	return name;
    }
}