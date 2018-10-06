package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Set;

public class Table {
	
	private ArrayList<Player> players;
	private Deck deck;
	private Set<Tile> meld;
	
	public Table() {
		Strategy stratPlayer = new FirstStrategy();
		Player gamer = new Player("Player 1", stratPlayer);
		Strategy stratA1 = new FirstStrategy();
		Player ai1 = new Player("AI 1", stratA1);
		Strategy stratA2 = new SecondStrategy();
		Player ai2 = new Player("AI 2", stratA2);
		Strategy stratA3 = new ThirdStrategy();
		Player ai3 = new Player("AI 3", stratA3);
		
		players.add(gamer);
		players.add(ai1);
		players.add(ai2);
		players.add(ai3);
		
		deck = new Deck();
		deck.Shuffle();
		
	}
	public Table(int num_Players) {
//		for (int i = 0; i < num_Players; i++) {
//			Player gamer = new Player("Player " + i);
//			players.add(gamer);
//		}
			
	}
	
	public int getNumPlayers() {
		return players.size();
	}
	
	
}
