/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lostcities;

import javacards.*;

/**
 *
 * @author paddy
 */
public class GameState {
    
    /**
     * Player 1
     */
    private Player player1;
    
    /**
     * Player 2
     */
    private Player player2;
    
    /**
     * The main pile to draw from
     */
    private Deck drawFromPile;
    
    /**
     * The throw away cards. 0 = Heart, 1 = Clubs, 2 = Diamonds, 3 = Spades, 4 = Doves
     */
    private Deck[] throwAways = new Deck[5];
    
    /**
     *	Creates a new GameState with player 1 human, player 2 as computer
     */
    public GameState()
    {
        player1 = createPlayer();
        player2 = createPlayer(false);
        drawFromPile = new Deck(5);
        drawFromPile.removeRank(1);
        dealToPlayers(player1, player2);
    }

    /**
     * Creates a new GameState with 2 players
     * @param human1 True if player1 should be human, false for computer
     * @param human2 
     */
	public GameState(boolean human1, boolean human2)
    {
        player1 = createPlayer(human1);
        player2 = createPlayer(human2);
        drawFromPile = new Deck(5);
        drawFromPile.removeRank(1);
        dealToPlayers(player1, player2);
    }
    
	/**
	 * Deals the starting hands
	 * @param player1 Who ever is player 1
	 * @param player2 Who ever is player 2
	 */
    private void dealToPlayers(Player player1, Player player2)
    {
		for(int i=0; i<8; i++)
		{
			player1.drawFromDeck(drawFromPile);
			player2.drawFromDeck(drawFromPile);
		}
	}

    /**
     * Creates a human or computer player
     * @param human1 True if the player should be human
     * @return
     */
    private Player createPlayer(boolean human) {
    	//TODO: Write a create player method
    	if (human)
    	{
    		return null;    		
    	}
    	else
    	{
    		//TODO: Should there be some way of creating an intelligent player?
    		return new RandomPlayer();
    	}
	}

	private Player createPlayer() {
    	//TODO: Write a create player method
		return null;
    }
    
    public Deck[] getThrowAways()
    {
        return throwAways;
    }
    
    public Deck getDrawFromDeck()
    {
    	return drawFromPile;
    }
}
