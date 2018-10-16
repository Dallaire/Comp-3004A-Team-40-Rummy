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
    	table.shareCards();
    	
    }
    
    public static void gameSetup() {
    	@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
    	
    	System.out.println("how many players are playing?");
        int input=scanner.nextInt();
         System.out.println(input);
    	// table= new Table(input);
    	        
	}
   
}
