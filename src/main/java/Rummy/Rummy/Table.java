package Rummy.Rummy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Table {
	
	private ArrayList<Player> players;
	private Deck stock;
	private HashSet<Tile> meld;
	private HashSet<HashSet<Tile>> melds;
	
	public Table() {
		Strategy stratPlayer = new FirstStrategy();
		Player gamer = new Player("Player 1", stratPlayer);
		Strategy stratA1 = new FirstStrategy();
		Player ai1 = new Player("AI 1", stratA1);
		Strategy stratA2 = new SecondStrategy();
		Player ai2 = new Player("AI 2", stratA2);
		Strategy stratA3 = new ThirdStrategy();
		Player ai3 = new Player("AI 3", stratA3);
		
		players = new ArrayList<Player>();
		players.add(gamer);
		players.add(ai1);
		players.add(ai2);
		players.add(ai3);
		
		stock = new Deck();
		stock.Shuffle();
		
		melds = new HashSet<HashSet<Tile>>();
		
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
	
	public int getNumTiles() {
		return stock.getSize();
	}
	public int getMelds() {
		
		return melds.size();
	}
//	private void setMelds(Set<Set<Tile>> melds) {
//		this.melds = melds;
//	}
	
	public boolean addMeld(HashSet<Tile> meld) {
		return this.melds.add(meld);
	}
	
	public void showMelds() {
		//TODO show all the Melds, right now a poorly defined datastructure
	}
	
	/**
	 * Method to get a specific tile
	 * @param c = colour of the Tile
	 * @param v = the value of the Tile*/
	public Tile getTile() {
		//TODO prompt user to select a color and value
		Tile tile = selectTile();
		return stock.getTile(tile);
	}
	
	public void displayStock() {
		System.out.println(stock.toString());
	}
	
	public Tile selectTile() {
		String[] inputArray;
		System.out.print("Please select a tile color followed by a value(separator = ,): \n");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		inputArray = input.split(",");
		
		Color color = colorSelector(inputArray[0]);
		int value = Integer.parseInt(inputArray[1]);
		
		Tile selected = new Tile(color, value);
		System.out.println("You selected " + selected.toString());
		
		scanner.close();
		
		return selected;
		
	}
	
	/**
	 * Check if the stock contains the specified tile
	 * For testing purposes*/
	public boolean stockContains(Tile tile) {
		// TODO Auto-generated method stub
		
		// return stock.contains(tile);
		return false;
	}
	/**
	 * Color selector: Given a string it will return a variable of Type Color
	 * @param c = the String value of the color desired
	 * @return Object of type Color or null if input is invalid
	 * */
	private Color colorSelector(String c) {
		String color =  c.toUpperCase();
		switch(color) {
		case "R":
			return Color.R;
		case "B":
			return Color.B;
		case "G":
			return Color.G;
		case "O":
			return Color.O;		
		default:
			return null;
		}
		
	}
	
	
}
