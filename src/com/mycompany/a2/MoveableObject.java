package com.mycompany.a2;

import com.codename1.ui.Component;

public abstract class MoveableObject extends GameObject implements IMoveable{
	
	private int speed; //can be 0-10
	private int heading; //can be 0-359
	
	public int getSpeed() {return speed;}
	public int getHeading() {return heading;}
	
	/**
	 * Defaults speed and heading to 0
	 */
	public MoveableObject() {
		speed=0; heading=0;
	}
	
	
	/**
	 * Checks to make sure speed is within acceptable range.
	 * If going faster than max, sets speed to max.
	 * If slower than 0, sets speed to 0.
	 * @param speed
	 */
	public void setSpeed(int speed) {
		if(speed>Util.MAX_SPEED) {
			System.err.println("Speed cannot exceed 10.");
			speed=Util.MAX_SPEED;
		}
		if(speed<0) {
			System.err.println("Speed cannot be lower than 0.");
			speed=0;
		}
		this.speed=speed;
		}
	
	/**
	 * Checks to make sure heading is in acceptable range
	 * @param heading
	 */
	public void setHeading(int heading) {
		while(heading<0)
			heading+=Util.MAX_HEADING;
		while(heading>=Util.MAX_HEADING)
			heading-=Util.MAX_HEADING;
		if(heading>=0&&heading<Util.MAX_HEADING)
			this.heading=heading;
		else
			System.err.println("Error setting heading to "+heading);
	}

	/**
	 * Uses trigonometry to increment object's position by the speed
	 * in the direction of the heading.
	 * Rounds to the tenths place.
	 */
	@Override
	public boolean move() {
		setX((double)Math.round((getX()+Math.cos(90-getHeading())*getSpeed())*10)/10);
		setY((double)Math.round((getY()+Math.sin(90-getHeading())*getSpeed())*10)/10);
		return true;
	}
	
	public String toString() {
		return super.toString() + "speed="+ speed + " dir=" + heading + " ";
	}
}
