package Rummy.Rummy;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Table table;
    public static void main( String[] args )
    {
    	gameSetup();
    	
    	
    }
    
    public static void gameSetup() {
    	Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("how many players are playing?");
        int input=scanner.nextInt();
         System.out.println(input);
    	 table= new Table();
    	        
	}
    public static void shareCards() {
		for(int i=0;i<14;i++) {
			table.getPlayer(i).addTile(table.getTile());
		}
	}
}
