package Rummy.Rummy;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStrategy extends Player implements Strategy {

	public PlayerStrategy(String aName) {
		super(aName);
	}

	//Logic is broken
	@Override
	public ArrayList<Tile> playTurn() {
		
		// let the player select the tiles they wish to play
		int[] indexes = readInput();
		meld.clear();
		// create the meld using the indexes
		for (int x: indexes) {
			
			System.out.println(x);
			System.out.println(this.getHand().size());
			Tile temp = this.getHand().get(x);
			meld.add(temp);
		}
		
		// if the meld is legit remove it from the hand
		if (!playedFirst30) {
			if(!MeldChecker.check30(meld)) {
				System.out.println("Not enough points buddy.");
				
			} 
			else {
			 //TODO actually playing the meld onto the table
				this.setFirst30(true);
			}
		}
		else {
			//TODO check if valid play and execute it
		}

		return meld; //????
	}
	
	/**
	 * Read the input from the console of the Player
	 * @return - an integer array of indexes the player wishes to create a meld from*/
	public int[] readInput() {
		
		System.out.println("Create your meld, select the tiles by index in comma separated list: ");
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split(",");
		int[] indexes = new int[input.length];
		
		for(int i = 0;i < input.length;i++)
		{
		   // Note that this is assuming valid input
		   // If you want to check then add a try/catch 
		   // and another index for the numbers if to continue adding the others (see below)
		   indexes[i] = Integer.parseInt(input[i]);
		}
		
		sc.close();
		
		return indexes;
	}


}
