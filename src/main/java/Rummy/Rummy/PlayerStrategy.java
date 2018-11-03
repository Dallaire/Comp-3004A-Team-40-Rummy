package Rummy.Rummy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStrategy extends Player implements Strategy {
	
	//Instance variables
	private ArrayList<String> fileInput = new ArrayList<String>();
	private String mode = "user";

	public PlayerStrategy(String aName) {
		super(aName);
	}

	//Logic is broken
	@Override
	/**
	 * @return - null if passing and or a meld*/
	public ArrayList<ArrayList<Tile>> playTurn() {
		
		// local variables
		int points = 0;
		boolean flag = true;		
		ArrayList<ArrayList<Tile>> melds = new ArrayList<ArrayList<Tile>>();
		
		// Put the player in a loop
		while (flag == true) {
			meld.clear();
			// Allow the player to choose what they want to do
			int choice = makeChoice();
			if (choice == 1) //play a meld from the hand
			{
				// let the player select the tiles they wish to play
				int[] indexes = selectTile();
				
				
				// create the meld using the indexes
				for (int x: indexes) {
					
					System.out.println(x);
					System.out.println(this.getHand().size());
					meld.add(this.getHand().get(x));
				}
				
				points += MeldChecker.countPoints(meld);
				
				// if the first thirty points aren't yet played check for that 
				if (getFirst30() == false) {
					if(MeldChecker.check30(meld) == false) {
						System.out.println("On first play the total points must be >=30");
						System.out.println("You currently have " + points + " points.");
						melds.add(meld);
					} else if(MeldChecker.checkRun(meld) == false && MeldChecker.checkSet(meld) == false) {
						System.out.println("Please play a valid run or set");
					} else if(MeldChecker.checkRun(meld) == true || MeldChecker.checkSet(meld) == true) {
						System.out.println("Player " + this.getName() + " played this meld: \n" + meld.toString());
						// change the first thirty flag
						this.playedFirst30 = true;
						melds.add(meld);

					}
				} 
				// if the first 30 points have already been played for this player				
				else if (getFirst30() == true) {
					
					//	Check if the meld is valid
					 if(MeldChecker.checkRun(meld) == false && MeldChecker.checkSet(meld) == false) {
						System.out.println("Please play a valid run or set");
						meld.clear();
					 } else if(MeldChecker.checkRun(meld) == true || MeldChecker.checkSet(meld) == true) {
							System.out.println("Player " + this.getName() + " played this meld: \n" + meld.toString());
							melds.add(meld);
					}
				}
				
				//Prompt user to play another meld
				// break or make another meld
				if(keepPlaying().equals("n")) {
					flag = false;
				}
				else {
					continue;
				}
			} 
			//pick a tile from the stock and pass on turn
			else if (choice == 2) 
			{
				this.addTile(Table.getTile());
				meld = null;
				flag = false;
			} 
			// Pass on the turn
			else {
				flag = false;
			}
		// end while loop	
		}

		return melds; //if the player passes, return null else return the meld
	}
	
	/**
	 * Read the input from the console
	 * @return - an integer array of indexes the player wishes to create a meld from*/
	public int[] selectTile() {
		String input;
		
		// if using file input because eclipse is being sexy
		if (getMode().equals("file")) {
			try {
				readInputFromFile("input2.txt");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			input = fileInput.get(0);
			
		} else {
			
			System.out.println("Create your meld, select the tiles by index in comma separated list: ");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				input = in.readLine();
			} catch (IOException e) {
				
				e.printStackTrace();
				input = "";
			}
		}
		

		System.out.println("input is: " + input);
		String[] array = input.split(",");
		int[] indexes = new int[array.length];
		
		for(int i = 0;i < array.length;i++)
		{
		   // Note that this is assuming valid input
		   // If you want to check then add a try/catch 
		   // and another index for the numbers if to continue adding the others (see below)
		   indexes[i] = Integer.parseInt(array[i]);
		}	
		
		
		return indexes;
	}
	
	/**
	 * Read the input from the console to device on action to take
	 * @return - an integer 1 for play a meld and 2 for */
	public int makeChoice() {
		
		
		int choice = 0;
		Scanner scanner = new Scanner(System.in);
		// Either from a pre-made file or 
		if (getMode().equals("file")) {
			try {
				readInputFromFile("input1.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			scanner.close();
			return Integer.parseInt(fileInput.remove(0));
		} else {
			
			while(true) {
				
				System.out.println("What would you like to do? \n 1) play a meld or \n 2) pick from the stock \n 3) pass without playing");			
				String input = scanner.nextLine();
				choice = Integer.parseInt(input);
				
				if (choice == 1 || choice == 2 || choice == 3) {
					scanner.close();
					break;
				}
				
			}
		}
		
		
		
		return choice;
	}
	
	/**
	 * Prompt the user to keep playing or pass*/
	public String keepPlaying() {
		
		System.out.println("Would you like to play another meld? y/n");
		String input;
		
		// Either read from a pre-made file or Scan from user input
		if (getMode().equals("file")) {
			try {
				readInputFromFile("input3.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			input = fileInput.get(0);
		} else {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			try {
				input = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				input = "n";
			}
		}

		
		return input.toLowerCase();
	}
	
	/**
	 * Read a text file containing all the moves the Player will make for the test
	 * @throws*/
	private void readInputFromFile(String file) throws IOException {
		// Open the file
		String root =  System.getProperty("user.dir");
		String filePath = "/src/main/8a/" + file;
		FileInputStream fstream = new FileInputStream(root + filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		fileInput.clear();
		String strLine;
		@SuppressWarnings("unused")
		int intBuff = 0;
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		 
		  //intBuff = Integer.parseInt(strLine);
		  fileInput.add(strLine);
		  
		}

		//Close the input stream
		br.close();
	}

	public String getMode() {
		return mode;
	}
	
	public void setMode(String mode) {
		this.mode = mode;
	}
 

}
