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
	private String fileName = "";
	private int x = 1;

	public PlayerStrategy(String aName, boolean isLocal) {
		super(aName, isLocal);
	}


	@Override
	/**
	 * Prompts the user to play a meld
	 * -Two modes: can read from file or prompt user through the console
	 * @return - ArrayList<ArrayList<Tile>> if valid  or null if passing and or a meld*/
	public ArrayList<ArrayList<Tile>> playTurn() {

		
		// local variables

		int points = 0;
		boolean flag = true;		
		ArrayList<ArrayList<Tile>> melds = new ArrayList<ArrayList<Tile>>();
		
		// Put the player in a loop
		while (flag == true) {
			meld = new ArrayList<Tile>();

			// Allow the player to choose what they want to do
			int choice = makeChoice();
			if (choice == 1) //create a meld from the hand
			{
				// let the player select the tiles they wish to play
				int[] indexes = selectTile();
		
				// create the meld using the indexes
				for (int x: indexes) {
					
					//System.out.println(x);
					//System.out.println(this.getHand().size());
					meld.add(this.getHand().get(x));
				}
				// remove tiles from the hand
				this.removeTiles(indexes);
				
				// if the first 30 points have already been played for this player				
				if (getFirst30() == true) {

					//	Check if the meld is valid
					 if(MeldChecker.checkRun(meld) == false && MeldChecker.checkSet(meld) == false) {
						System.out.println("Please play a valid run or set");
						meld.clear();
					 } else if(MeldChecker.checkRun(meld) == true || MeldChecker.checkSet(meld) == true) {
							System.out.println("Player " + this.getName() + " played this meld: \n" + meld.toString());
							melds.add(meld);
					}
				}
				// if the first thirty points aren't yet played check for that 
				else if (getFirst30() == false) {

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
				
				//Prompt user to play another meld
				// break or make another meld
				
				// Count the points
				points = 0;
				for (ArrayList<Tile> tiles: melds) {
					points += MeldChecker.countPoints(tiles);
				}
				
				System.out.println("You have " + points +  " points");
				
				if(keepPlaying().equals("n")) {
					flag = false;
					

					if (points < 30 && getFirst30() == false) {
						System.out.println("Player ones melds do not have enough points to play to the Table");
						addMelds(melds);
						this.addTile(Table.getTile());
						melds =  null;
					}
				}
				else {
					continue;
				}
			// End of choice == 1
				
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
				readInputFromFile("input" + Integer.toString(x++) +".txt");
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
				readInputFromFile("input" + Integer.toString(x++) +".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			scanner.close();
			return Integer.parseInt(fileInput.remove(0));
		} else {
			System.out.println("Table: " + Table.getMelds());
			System.out.println("What would you like to do? \n 1) play a meld or \n 2) pick from the stock \n 3) pass without playing");
			String input = scanner.nextLine();
			choice = Integer.parseInt(input);
			scanner.reset();
		}

		return choice;
	}
	public void selectBoardTile() {
		System.out.println("Please enter the number of melds you want to modify from the Table: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =0; i<n; i++) {
			System.out.println("Table: " + Table.getMelds());
			System.out.println("Please enter which meld you would like to add to your Hand: ");
			int meld = sc.nextInt();
			/*
			 * Have to add entire meld to players hand so that the player can make new melds
			 * and play those to the board instead of trying to add back to the meld that the player
			 * just took a tile from
			 */
			for(Tile tile : Table.getMeld(meld)) {
				this.getHand().add(tile);
			}
			Table.remove(meld);
		}
		
		sc.close();
	}
	
	/**
	 * Prompt the user to keep playing or pass*/
	public String keepPlaying() {
		
		System.out.println("Would you like to play another meld? y/n");
		String input;
		
		// Either read from a pre-made file or Scan from user input
		if (getMode().equals("file")) {
			try {
				readInputFromFile("input" + Integer.toString(x++) +".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			input = fileInput.get(0);
		} else {
			Scanner scanner = new Scanner(System.in);
			input = scanner.nextLine();
			scanner.reset();
		}

		
		return input.toLowerCase();
	}
	
	/**
	 * Read a text file containing all the moves the Player will make for the test
	 * @throws*/
	private void readInputFromFile(String file) throws IOException {
		// Open the file
		String root =  System.getProperty("user.dir");
		String filePath = "/src/main/"+ fileName + "/" + file;
		FileInputStream fstream = new FileInputStream(root + filePath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		fileInput.clear();
		String strLine;
		
		//Read File Line By Line
		while ((strLine = br.readLine()) != null)   {
		  fileInput.add(strLine);		  
		}

		//Close the input stream
		br.close();
	}

	/**
	 * A string representation of how the PlayerStrategy will be executed
	 * @return - The mode that the player is in: Either "file" or "user" mode*/
	public String getMode() {
		return mode;
	}
	
	/**
	 * The the mode the player will be in
	 * */
	public void setMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Sets the file name of the input file for testing*/
	public void setFile(String file) {
		this.fileName  = file;
	}
}
