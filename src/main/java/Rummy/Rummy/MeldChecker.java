package Rummy.Rummy;

import java.util.ArrayList;

public class MeldChecker {
	public boolean checkHand(ArrayList<Tile> hand) {
		if(checkSet(hand)||checkRun(hand)) {
			return true;
		}else {
			return false;
		}
	}
	public  static boolean checkSet(ArrayList<Tile> meld) {
		for (int i = 0,j=1; j < meld.size(); i++,j++) {
			if (meld.get(i).getValue()!=meld.get(j).getValue()) {
				
				return false;
			}
		}
		return true;
	}
	public static boolean checkRun(ArrayList<Tile> meld) {
		for (int i = 0, j=1; j < meld.size(); i++,j++) {
			if (!checkDifference(meld.get(i), meld.get(j))) {
				return false;
			}
			if (!checkColor(meld.get(i), meld.get(i+1))) {
				return false;
			}
			
		}
		return true;
		
	}
	public static boolean check30(ArrayList<Tile> meld) {
		int sum=0;
		for(int i=0;i<meld.size();i++) {
			sum+=meld.get(i).getValue();
		}
		if (sum>=30) {
			return true;
		}
		return false;
		
	}	
	/**
	 * compares the color of the 2 giver tiles and returns true if equal otherwise false*/
	public static boolean checkColor(Tile t1,Tile t2) {
		return t1.colorToString().equals(t2.colorToString());
	}
	/**
	 * compares the value of the 2 giver tiles and returns true if the difference=1 otherwise false*/
	public static boolean checkDifference(Tile t1, Tile t2) {
		if ((t2.getValue()-t1.getValue())==1) {
			return true;
		}
		return false;
	}
	public static int checkSum(ArrayList<Tile> meld) {
		int sum=0;
		for (int i = 0; i < meld.size(); i++) {
			//System.out.println("sum"+sum);
			sum+=meld.get(i).getValue();
		}
		//System.out.println("sum"+sum);

		return sum;
		
	}
}
