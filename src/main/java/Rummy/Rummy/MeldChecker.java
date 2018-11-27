package Rummy.Rummy;

import java.util.ArrayList;

public class MeldChecker {
	public static boolean checkHand(ArrayList<Tile> hand) {
		if(checkSet(hand)||checkRun(hand)) {
			return true;
		}else {
			return false;
		}
	}
	public  static boolean checkSet(ArrayList<Tile> meld) {
		meld.sort(new valueComparator());
		for (int i = 0,j=1; j < meld.size(); i++,j++) {
			if (meld.get(i).getValue()!=meld.get(j).getValue()) {
				return false;
			}
			if (checkColor(meld.get(i),meld.get(j))){
				return false;
				}
		}
		return true;
	}
	public static boolean checkRun(ArrayList<Tile> meld) {
		meld.sort(new valueComparator());
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
		meld.sort(new valueComparator());
		int sum=0;
		for(int i=0;i<meld.size();i++) {
			if (meld.get(i).getValue() == 0) {
				sum+= ((Joker)meld.get(i)).getMask();
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
		if (t1.getColor() == null || t2.getColor() == null) return true;
		return t1.colorToString().equals(t2.colorToString());
	}
	/**
	 * compares the value of the 2 giver tiles and returns true if the difference=1 otherwise false*/
	public static boolean checkDifference(Tile t1, Tile t2) {
		if (t1.getValue() == 0) {return ((t2.getValue() - ((Joker)t1).getMask()) == 1);}
		else if (t2.getValue() == 0) {return ((((Joker)t2).getMask() - t1.getValue()) == 1);}
		if ((t2.getValue()-t1.getValue())==1) {
			return true;
		}
		return false;
	}
	public static int checkSum(ArrayList<Tile> meld) {
		int sum=0;
		for (int i = 0; i < meld.size(); i++) {
			//System.out.println("sum"+sum);
			if (meld.get(i).getValue() == 0) {
				sum+= ((Joker)meld.get(i)).getMask();
			}
			else sum+=meld.get(i).getValue();
		}
		//System.out.println("sum"+sum);

		return sum;
		
	}
	/**
	 * Count Points in a meld
	 * @param meld - the Arraylist of melds containing Tiles
	 * @return - The integer value of the number of points in the meld*/
	public static int countPoints(ArrayList<Tile> meld) {
		int mpoints = 0;
		for(Tile t: meld)
		{
			if (t.getValue() == 0)
				mpoints += ((Joker)t).getMask();
			else mpoints += t.getValue();
		}
		return mpoints;
	}
}
