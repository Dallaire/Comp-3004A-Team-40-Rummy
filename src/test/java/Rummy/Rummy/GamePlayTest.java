/**
 * 
 */
package Rummy.Rummy;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * @author poe
 *
 */
public class GamePlayTest extends TestCase{

	@Test
	public void testCycle() {

		Table.init();
		Table.playNext();
	}
	
	/**
	 * Test on how to differentiate between ai and human player*/
	public void testDiff() {
		PlayerStrategy p1 = new PlayerStrategy("dude");
		PlayerStrategy p2 = new PlayerStrategy("another dude");
		FirstStrategy ai1 = new FirstStrategy("AI 1");
		SecondStrategy ai2 = new SecondStrategy("AI 2");	
		ThirdStrategy ai3 = new ThirdStrategy("AI 3");
		
		assertEquals(p1 instanceof PlayerStrategy, p2 instanceof PlayerStrategy); 
		assertEquals(p1 instanceof PlayerStrategy, ai1 instanceof Player); 
		assertEquals(p1 instanceof PlayerStrategy, ai2 instanceof SecondStrategy);
		assertEquals(p1 instanceof PlayerStrategy, ai3 instanceof ThirdStrategy);

	}
	
	
	public void testPlayerReadInput() {
		PlayerStrategy p1 = new PlayerStrategy("dude");
		int[] array = p1.selectTile();
		int[] array2 =  {1,2,3};
		assertArrayEquals(array2, array);
		
 	}
	
	public void testPlayerTurn() {

		Table.init();
		Table.playNext();
		
		//assertArrayEquals(array2, array);
		
 	}
	
	public void testPointChecker_1() {

		ArrayList<Tile> meld = new ArrayList<Tile>();
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		meld.add(new Tile(Color.R, 1));
		
		assertEquals(7, MeldChecker.countPoints());
		
 	}
	
	
	/**
	 * Check that the down casting works*/
	public void testPlayerTypes() {
		
		assertEquals(true, Table.getPlayer(0) instanceof PlayerStrategy);
		assertEquals(false, Table.getPlayer(1) instanceof PlayerStrategy);
		assertEquals(false, Table.getPlayer(2) instanceof PlayerStrategy);
		assertEquals(false, Table.getPlayer(3) instanceof PlayerStrategy);
	}
	
	/***/
	public void testRemoveTile() {
		
	
		PlayerStrategy p1 = (PlayerStrategy) Table.getPlayer(0);
		p1.printTiles();
		
		
	}
	
	public void testAllDrawFromStock() {
		Table.init();
		Table.playNext();
		Table.playNext();
		Table.playNext();
		
	}
	
	/**
	 * To that the player can pass on a turn*/
	public void testPlayerPass() {
		Table.init();
		Table.playNext();
	}

}
