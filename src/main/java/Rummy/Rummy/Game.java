package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	
	private String gameInput;
	private String playerInput;
	private int turns = 0;
	Table table = new Table();;

	public Game() {
		
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Would you Like to play a new game?(Y/N)");
			gameInput = sc.nextLine().toUpperCase();
			if(gameInput.equals("N")) { 
				break;
			}else {
				/** 
				 * while the player has cards to play ask if they want to play a run or meld
				 */
				System.out.println("Would you like to play a Run(R) or Meld(M)");
				playerInput = sc.nextLine().toUpperCase();
			}
			
		}
	}
	
	public String getGameInput() {
		return this.gameInput;
	}
	public String getPlayerInput() {
		return this.playerInput;
	}
	/**
	 * Cycle through players in the table*/
	public void loop() {
		
		int n = table.getNumPlayers();
		for (int i = 0; i < n; i++) {
			this.turns++;
			
			//
		}
			
		
	}

	/**
	 * @return the turns
	 */
	public int getTurns() {
		return this.turns;
	}

	
}
