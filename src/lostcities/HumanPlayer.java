package lostcities;

import javacards.*;

public class HumanPlayer extends Player 
{
	
	public HumanPlayer(String name)
	{
		super(name);
	}

	@Override
	public Deck getDeckToDrawFrom(GameState gamestate) {
		// TODO Get a user input and get the deck to draw from
		return null;
	}

	@Override
	public Pair<Card, Deck> chooseACardToPlay(GameState gameState) {
		// TODO Get user input to get the card to play and which deck to play on.
		return null;
	}
}
