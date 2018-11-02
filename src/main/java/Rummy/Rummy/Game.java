package Rummy.Rummy;
import java.util.Scanner;

public class Game {
	private static String gameInput;
	public static void main(String[] args) {
		play();
	}
	/**
	 * Game Loop
	 * takes in a p1 hand and asks them how they want them to play the game.
	 */
	public static void play() {
		System.out.println("Would you like to play Rummy(Y/N)");
		Scanner sc = new Scanner(System.in);
		gameInput = sc.nextLine();
		if(gameInput.equals("Y")) {
			Table.init();
			while(true) {
				Table.playNext();
			}
		}	
	}
	
	
	
	public String getGameInput() {
		return this.gameInput;
	}



	/**
	 * @return the turns
	 */


	
}
