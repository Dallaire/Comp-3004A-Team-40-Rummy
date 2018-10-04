package Rummy.Rummy;


public class Tile {
	private Color color;
	//Ace =1, j-K = 11-13
	private int value;

	public Tile(Color aColor, int aValue) {
		this.color = aColor;
		this.value = aValue;
	}

	public Color getColor() {
		return this.color;
	}
	
	public int getValue() {
		return this.value;
	}
}
