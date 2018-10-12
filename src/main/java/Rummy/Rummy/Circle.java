package Rummy.Rummy;

import java.util.Random;

public class Circle {
	
	private double x;
	private double y;
	private double centreX;
	private double centreY;
	
	public Circle(double x, double y, double cx, double cy) {
		this.x = x;
		this.y = y;
		this.centreX = cx;
		this.centreY = cy;
	}
	
	
	public Circle() {
		Random rn = new Random();
		this.x = rn.nextDouble()*480;
		this.y = rn.nextDouble()*480;
	}
	
	public void update(double t) {
        this.x = centreX + 80 * Math.cos(t);
        this.y = centreY + 32 * Math.sin(t);
	}

	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	
}
