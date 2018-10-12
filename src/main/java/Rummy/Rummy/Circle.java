package Rummy.Rummy;

import java.util.Random;

public class Circle {
	
	private double x;
	private double y;
	private double centreX;
	private double centreY;
	private double phase;
	private double f;
	Random rn = new Random();
	
	public Circle(double x, double y, double cx, double cy) {
		this.x = x;
		this.y = y;
		this.centreX = cx;
		this.centreY = cy;
		this.phase = rn.nextDouble() * Math.PI;
		this.f = rn.nextDouble();
	}
	
	
	public Circle() {
		
		this.x = rn.nextDouble()*480;
		this.y = rn.nextDouble()*480;
	}
	
	public void update(double t) {
        this.x = centreX + 40 * Math.cos((1/f)*t + this.phase);
        this.y = centreY + 40 * Math.sin((1/f)*t + this.phase);
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