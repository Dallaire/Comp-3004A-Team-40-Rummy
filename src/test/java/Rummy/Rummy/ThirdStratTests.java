package Rummy.Rummy;

import java.util.ArrayList;

import junit.framework.TestCase;

public class ThirdStratTests extends TestCase {
	
	public void testPlayFirst30Immediately() {
		Table.loadPlayers();
		Table.getMelds().clear();
		ThirdStrategy player = (ThirdStrategy)Table.getPlayer(3);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 12));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 9));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false));
		player.playTurn2(Table.getMelds());
		
		assertTrue(!Table.getMelds().isEmpty());
	}
	
	public void testPlayFirst30Later() {
		Table.init();
		Table.getMelds().clear();
		ThirdStrategy player = (ThirdStrategy)Table.getPlayer(3);
		player.getHand().clear();
		player.addTile(new Tile(Color.B, 10));
		player.addTile(new Tile(Color.B, 11));
		player.addTile(new Tile(Color.B, 4));
		player.addTile(new Tile(Color.B, 5));
		player.addTile(new Tile(Color.B, 8));
		player.addTile(new Tile(Color.O, 1));
		player.addTile(new Tile(Color.O, 2));
		player.addTile(new Tile(Color.O, 3));
		player.addTile(new Tile(Color.O, 4));
		player.addTile(new Tile(Color.O, 9));
		player.addTile(new Tile(Color.R, 8));
		player.update(new JRON(new ArrayList<ArrayList<Tile>>(),true,false));
		player.playTurn2(Table.getMelds());
		
		assertTrue(Table.getMelds().isEmpty());
		
		player.addTile(new Tile(Color.B, 12));
		player.playTurn2(Table.getMelds());
		
		assertTrue(!Table.getMelds().isEmpty());
	}
}
