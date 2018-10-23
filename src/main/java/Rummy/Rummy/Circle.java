package Rummy.Rummy;

import java.util.Random;

public class Circle {
	
	private double x;
	private double y;
	private double centreX;
	private double centreY;
	private double phase;
	private double f;
	private double aX;
	private double aY;
	private double amp;
	private double sign;
	private boolean targetSet = false;
	private double acc;
	private double vYi = 0.0;
	private double vXi = 0.0;
	private double k;
	private double told = 0;
	Random rn = new Random();
	
	public Circle(double x, double y, double cx, double cy) {
		this.x = x;
		this.y = y;
		this.centreX = cx;
		this.centreY = cy;
		this.phase = rn.nextDouble() * Math.PI;
		this.f = rn.nextDouble();
		this.amp = rn.nextDouble()*5.0;
		this.k = rn.nextDouble()*10.0;
		if (rn.nextBoolean() == false) {
			this.sign = -1.0;
		}
		else {
			this.sign = 1.0;
		}
	}
	
	
	public Circle() {
		
		this.x = rn.nextDouble()*480.0;
		this.y = rn.nextDouble()*480.0;
	}
	
	public void update(double t) {
		if(!this.targetSet) {
	        this.x =  centreX + this.sign *this.amp * 40 * Math.cos((1/f)*t + this.phase);
	        this.y =  centreY + this.sign *this.amp * 40 * Math.sin((1/f)*t + this.phase);
		} else {
			//calculate the acceleration 
			t = t - this.told;
			double h = Math.sqrt((360.0 - this.x)*(360.0 - this.x) + (240 - this.y)*(240 - this.y));
			this.acc = k / (h*h);
			this.aX = this.acc * Math.cos((360.0 - this.x)/h);
			this.aY = this.acc * Math.sin((240.0 - this.y)/h);
			//calculate the velocity
			this.vXi = this.vXi + this.aX * t;
			this.vYi = this.vYi + this.aY * t;
			// calculate the new position
			this.x += (this.vXi) + 0.5 * this.aX * t * t;
			this.y += (this.vYi) + 0.5 * this.aY * t * t;
			this.told = t;
		}

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
	
	public void setTarget() {
		this.targetSet = true;
	}
	
	
	
}
