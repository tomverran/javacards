package lostcities;

import java.util.ArrayList;

import javacards.Card;
import javacards.Deck;
import javacards.Suit;

public class RandomPlayer extends Player {

	/**
	 * Creates a new instance of RandomPlayer
	 * @param n The name of the player
	 */
	public RandomPlayer(String n) {
		super(n);
	}
	
	/**
	 * Creates a new player with a random name
	 */
	public RandomPlayer()
	{
		super(getRandomName());
	}

	/**
	 * Gets a random name from the list.
	 * @return
	 */
	private static String getRandomName()
	{
		String[] names =
		{
			"Computer",
			"CPU"
		};
		int randomNumber = (int)(Math.random()*names.length);
		return names[randomNumber];
	}

	@Override
	public Pair<Card, Deck> chooseACardToPlay(GameState gameState) 
	{
		ArrayList<Card> hand = getHand();
		Card card = hand.get((int)Math.random()*hand.size());
		int suitAsDeck = Suit.toInt(card.getSuit());
		Deck[] expeditions = getExpeditions(); 
		Deck deck;
		if (canPlay(card, expeditions[suitAsDeck].getTopCard().getRank()))
		{
			deck = expeditions[suitAsDeck];
		}
		else
		{
			deck = gameState.getThrowAways()[suitAsDeck];
		}
		return new Pair<Card, Deck>(card, deck);
	}

	private boolean canPlay(Card card, int rank) 
	{
		if (rank<11)
		{
			return true;
		}
		return rank<card.getRank();
	}

	@Override
	public Deck getDeckToDrawFrom(GameState gamestate) 
	{
		return gamestate.getDrawFromDeck();
	}
}