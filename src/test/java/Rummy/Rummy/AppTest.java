package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.TestCase;

/**
 * Unit test for simple 
 */
public class AppTest extends TestCase
{
    public void testTile() {
    	Tile tile = new Tile(Color.O, 10);
    	assertEquals(Color.O, tile.getColor());
    	assertEquals(10, tile.getValue());
    	assertEquals("O10", tile.toString());
    }
    
    public void testDeck() {
    	Deck deck = new Deck();
    	assertEquals(104, deck.getSize());
    	assertNotNull(deck.geTile(0));
    	assertEquals(103, deck.getSize());
    }
    
    public void testPlayer() {
    	Strategy first = new FirstStrategy();
    	Player player = new Player("John", first);
    	assertEquals("John", player.getName());
    	assertEquals(first, player.getStrategy());
    }
    
    public void testAddTile() {
    	Strategy first = new FirstStrategy();
    	Player player = new Player("John", first);
    	player.addTile(new Tile(Color.O, 10));
    	assertEquals(1,player.getHand().size());
    }
    public void testStrategy() {
    	//Table table= new Table();		
    	//Strategy stratA1;
    	
    	Deck stock = new Deck();
		stock.Shuffle();
		Player ai1 = new Player("AI 1");
		Strategy stratA1 = new FirstStrategy(ai1);
	//	ai1.setStrategy(stratA1);
    	//ArrayList<Tile> aHand= new ArrayList<Tile>();
		ai1.getHand().add(new Tile(Color.O, 6));

		ai1.getHand().add(new Tile(Color.G, 6));
		ai1.getHand().add(new Tile(Color.R, 12));
		ai1.getHand().add(new Tile(Color.B, 1));
		ai1.getHand().add(new Tile(Color.B, 12));
		ai1.getHand().add(new Tile(Color.G, 6));


    	//ai1.getCards(stock);
		//ai1.customFillHand();
//    	for (int i = 0; i < 14; i++) {
//        	System.out.println(ai1.getHand().get(i).toString());
//		}
		Collections.sort(ai1.getHand(),new valueComparator());
		for (int i = 0; i < ai1.getHand().size(); i++) {
			System.out.println(ai1.getHand().get(i).toString());
		}
    	ArrayList<Tile> meld=stratA1.checkSet(ai1.getHand());
    	
   	for (int i = 0; i < meld.size(); i++) {
   			
    		System.out.print(","+meld.get(i).toString());
	}
    	
    	assertEquals("AI 1", ai1.getName());
    	//ai1.playTurn();
    	
    }

}
