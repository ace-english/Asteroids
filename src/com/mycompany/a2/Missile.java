package com.mycompany.a2;

public abstract class Missile extends MoveableObject{
	private int fuelLevel;
	public static int SPEED_INCREMENT = 2;
	
	/**
	 * Copies the speed and heading of the missileLauncher that fired it.
	 * @param speed
	 * @param heading
	 */
	Missile(MissileLauncher ml){
		setSpeed(ml.getSpeed()+SPEED_INCREMENT);
		setHeading(ml.getHeading());
		setX(ml.getX());
		setY(ml.getY());
		fuelLevel=10;
	}

	/**
	 * Checks to see if fuel is not depleted, and increments position if there is still fuel
	 */
	@Override
	public boolean move() {
		if(fuelLevel>0) {
			super.move();
			fuelLevel--;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return super.toString()+ "fuel="+fuelLevel+" "; 
	}

}
