package Rummy.Rummy;

import junit.framework.TestCase;

public class FirstStratTests extends TestCase {
	public void testNot30Played() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 1));
		player.addTile(new Tile(Color.B, 2));
		player.addTile(new Tile(Color.B, 3));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(false);
		player.playTurn(Table.getMelds());
			
		assertEquals(13,player.getHand().size());
		
	}
	public void testPlay30Run(){
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 12));
		player.addTile(new Tile(Color.B, 13));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(false);
		player.playTurn(Table.getMelds());
			
		//should only have 8 cards in hand after playing first 30
		assertEquals(8,player.getHand().size());
	}
	public void testPlay30Set() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.R, 10));
		player.addTile(new Tile(Color.G, 10));
		player.addTile(new Tile(Color.O, 10));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 8));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(false);
		player.playTurn(Table.getMelds());
		System.out.println(player.getHand().size());
		System.out.println("Printing Player Hand: " + player.getHand());
		//should only have 8 cards in hand after playing first 30
		assertEquals(8,player.getHand().size());
	}
	
	public void testPlayRun() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 1));
		player.addTile(new Tile(Color.R, 2));
		player.addTile(new Tile(Color.G, 3));
		player.addTile(new Tile(Color.O, 6));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 9));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(true);
		
		player.playTurn(Table.getMelds());
		System.out.println("Test Hand: " + player.getHand());
		//should only have 8 cards in hand after playing a run
		assertEquals(8,player.getHand().size());
	}
	public void testPlaySet() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 6));
		player.addTile(new Tile(Color.R, 6));
		player.addTile(new Tile(Color.G, 6));
		player.addTile(new Tile(Color.O, 6));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.G, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.R, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(true);
		player.playTurn(Table.getMelds());
		System.out.println(player.getHand().size());
		System.out.println("Printing Player Hand: " + player.getHand());
		//should only have 8 cards in hand after playing first 30
		assertEquals(8,player.getHand().size());
	}
	
	public void testMelds() {
		Table.init();
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 6));
		player.addTile(new Tile(Color.R, 6));
		player.addTile(new Tile(Color.G, 6));
		player.addTile(new Tile(Color.O, 6));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.G, 1));
		player.addTile(new Tile(Color.G, 2));
		player.addTile(new Tile(Color.G, 3));
		player.addTile(new Tile(Color.G, 4));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.R, 8));
		player.setFirst30(true);
		player.playTurn(Table.getMelds());
		System.out.println("Printing Player Hand: " + player.getHand());
		//should only have 8 cards in hand after playing first 30
		assertEquals(4,player.getHand().size());
	}
	public void testPlayedTurn() {
		Table.loadPlayers();
		Table.getMelds().clear();
		FirstStrategy player = (FirstStrategy)Table.getPlayer(1);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 6));
		player.addTile(new Tile(Color.R, 6));
		player.addTile(new Tile(Color.G, 6));
		player.addTile(new Tile(Color.O, 6));
		player.addTile(new Tile(Color.G, 1));
		player.addTile(new Tile(Color.G, 2));
		player.addTile(new Tile(Color.G, 3));
		player.addTile(new Tile(Color.G, 4));
		player.addTile(new Tile(Color.B, 9));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 8));
		
		player.playTurn(Table.getMelds());
		assertTrue(player.getFirst30());
		player.playTurn(Table.getMelds());
		assertEquals(0,player.getHand().size());
		
		
	}
}
