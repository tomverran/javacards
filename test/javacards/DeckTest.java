package javacards;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Tom
 */
public class DeckTest {
    
    private Deck deck;
    
    /**
     * Construct our unit test? :/
     */
    public DeckTest() {
    }

    @Before
    public void setUp() 
    {
        this.deck = new Deck();
    }

    /**
     * Test of getCards method, of class Deck.
     * Checking I get five cards and don't alter the original
     */
    @Test(expected=IndexOutOfBoundsException.class)
    public void testGetCards_int() 
    {
        //check stuff that should work
        int oldsize = this.deck.size();
        ArrayList<Card> cards = this.deck.getCards(5);
        assertEquals(cards.size(),5);
        assertEquals(cards.get(0),deck.getTopCard());
        assertEquals(deck.size(),oldsize);
        
        //should throw IndexOutOfBounds
        this.deck.getCards(-1);
    }
}
