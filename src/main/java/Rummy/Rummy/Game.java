package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	
	private String gameInput;
	private String playerInput;

	

	public Game() {
		play();
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public void play() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to play the game Rummy(Y/N)");
		playerInput = sc.nextLine().toUpperCase();
		if(playerInput.equals("Y")) {
			Table.init();
			while(!Table.winner()) {
				Table.playNext();
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
