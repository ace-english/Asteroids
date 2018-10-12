package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class MissileLauncher extends MoveableObject{

	private Ship ship;
	
	public MissileLauncher(Ship ship){
		this.ship=ship;
		setColor(ColorUtil.YELLOW);
		setX(ship.getX());
		setY(ship.getY());
		setHeading(ship.getHeading());
		setSpeed(ship.getSpeed());
	}
	
	/**
	 * The following are getter overrides.
	 * MissileLauncher should not have its own members for
	 * x, y and speed: it should be the same as its ship's
	 */
	public int getSpeed() {return ship.getSpeed();}
	public double getX() {return ship.getX();}
	public double getY() {return ship.getY();}
	
	/**
	 * Creates missile with heading of owning Launcher
	 */
	public Missile fire() {
		return new NPSMissile(this);
	}

}
