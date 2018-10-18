package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	
	private String gameInput;
	private String playerInput;
	private Player p1,p2,p3,p4;
	private int turns = 0;
	Table table = new Table();;

	public Game() {
		play();
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
				 * if game is won break else run the game.
				 */
				if() {
					break;
				}else {
					run(p1,p2,p3,p4,this.table);
				}
				
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
	 * Cycle through players in the table
	 * It needs to be an infinite loop until the game ends
	 */
	public void run(Player human, Player stratOne, Player stratTwo, Player stratThree, Table board) {
		if(this.turns == 0) {
			human.playTurn();
		}else if(this.turns == 1) {
			stratOne.playTurn();
		}else if(this.turns == 2) {
			stratTwo.playTurn();
		}else {
			stratThree.playTurn();
		}
	}
	public void loop() {
		int n = table.getNumPlayers();
		while(true) {
			if(n==4) {
				this.turns = 0;
			}else {
				this.turns++;
			}
		}
		
			
		
	}

	/**
	 * @return the turns
	 */
	public int getTurns() {
		return this.turns;
	}

	
}
