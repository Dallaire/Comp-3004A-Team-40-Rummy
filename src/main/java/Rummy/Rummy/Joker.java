package Rummy.Rummy;

public class Joker extends Tile{
	int maskValue = 0;
	
	public Joker(Color aColor, int aValue) {
		super(null, 0);
	}

	public int getMask() {
		return maskValue;
	}
	
	public void setMask(int aValue) {
		maskValue = aValue;
	}
}
