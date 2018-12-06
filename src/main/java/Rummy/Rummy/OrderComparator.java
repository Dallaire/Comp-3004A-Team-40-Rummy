package Rummy.Rummy;

import java.util.Comparator;

public class OrderComparator implements Comparator<Player> {
	@Override
	public int compare(Player o1, Player o2) {
	 	Integer i1 = o1.getRandomValue();
	 	Integer i2 = o2.getRandomValue();
        int comp = i1.compareTo(i2) * -1;
        if (comp != 0)
        	return comp;
        else {
        	System.out.println(o1.getName() + " and " + o2.getName() + " tied. Drawing again.");
        	o1.newRandomValue();
        	o2.newRandomValue();
        	System.out.println(o1.getName() + " drew " + o1.getRandomValue());
        	System.out.println(o2.getName() + " drew " + o2.getRandomValue());
        	return compare(o1,o2);
        }
    }
}
