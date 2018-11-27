package Rummy.Rummy;

import java.util.Comparator;

public class valueComparator implements Comparator<Tile> {

	 @Override
	 /**
		 * sorts the hand by value*/
	    public int compare(Tile o1, Tile o2) {
		 	Color c1 = o1.getColor();
		 	Color c2 = o2.getColor();
		 	int comp;
		 	if (c1 == null) 
		 		comp = -1;
		 	else if (c2 == null)
		 		comp = 1;
		 	else comp = c1.compareTo(c2);
		 	
		 	if (comp != 0) {return comp;}
		 	
		 	Integer i1 = o1.getValue();
		 	if (i1 == 0) i1 = o1.getMask();
		 	Integer i2 = o2.getValue();
		 	if (i2 == 0) i2 = o2.getMask();
	        return i1.compareTo(i2);
	    }
		
}
