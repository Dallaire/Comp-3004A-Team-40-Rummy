package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	
	private String gameInput;
	private String playerInput;
<<<<<<< HEAD

=======
	private boolean won = false;
	private int turns = 0;
	
>>>>>>> 1aab20e070417eccc3a34589a1a04a325625c37e
	

	public Game() {
		play();
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
<<<<<<< HEAD
		System.out.println("Would you like to play the game Rummy(Y/N)");
		playerInput = sc.nextLine().toUpperCase();
		if(playerInput.equals("Y")) {
			Table.init();
			while(!Table.winner()) {
				Table.playNext();
=======
		while(true) {
			System.out.println("Would you Like to play a new game?(Y/N)");
			gameInput = sc.nextLine().toUpperCase();
			if(gameInput.equals("N")) {
				sc.close();
				break;
			}else {
				/** 
				 * if game is won break else run the game.
				 */
				if(won) {
					break;
				}else {
					run((PlayerStrategy)Table.getPlayer(0),(FirstStrategy)Table.getPlayer(1),(SecondStrategy)Table.getPlayer(2),(ThirdStrategy)Table.getPlayer(3),this.Table);
				}
				
>>>>>>> 1aab20e070417eccc3a34589a1a04a325625c37e
			}
		}else {
			sc.close();
		}
	}
	
	
	public String getGameInput() {
		return this.gameInput;
	}
	public String getPlayerInput() {
		return this.playerInput;
	}


	 public void run() {
		 Table.playNext();	 
	}

	/**
	 * @return the turns
	 */


	
}
