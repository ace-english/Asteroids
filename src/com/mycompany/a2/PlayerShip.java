package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;

public class PlayerShip extends Ship implements ISteerable{

	//ensures that only one instance of PlayerShip can exist at once.
	private static PlayerShip PS;
	
	//private data members
	private final static int MAX_MISSILES=10;
	
	private PlayerShip() {
		//Initialize to center of screen, facing up.
		setX(Util.getMaxWidth()/2);
		setY(Util.getMaxWidth()/2);
		setColor(ColorUtil.GREEN);
		setHeading(0);
		setSpeed(0);
		missileLauncher=new SteerableMissileLauncher(this);
		setMissileCount(MAX_MISSILES);
	}
	
	/**
	 * returns reference to static PlayerShip
	 */
	public static PlayerShip getPS() {
		if(PS==null)
			PS=new PlayerShip();
		return PS;
	}
	
	/**
	 * Resets missile count. Useful for visiting space stations.
	 */
	public void restock() {
		setMissileCount(MAX_MISSILES);
	}

	/**
	 * Rotates ship by 45 degrees, either left or right.
	 */
	@Override
	public void turn(Util.Direction direction) {
		int interval=45;
		if(direction==Util.Direction.left) interval*=-1;
		setHeading(getHeading()+interval);
	}
	
	public String toString() {
		return "Player Ship: "+super.toString() + "Missile launcher dir = "+missileLauncher.getHeading()+" ";
	}
}
