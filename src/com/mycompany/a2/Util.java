package com.mycompany.a2;

import java.util.Random;

import com.codename1.ui.Component;

public class Util {
	
	public enum ObjectType {Asteroid, MissileLauncher, NPS, NPSMissile, PlayerShip, PlayerMissile, Station}
	public enum Direction{left, right};
	public static final int MAX_HEADING = 360;
	public static final int MAX_SPEED = 10;
	
	//pseudo constants declared when Map is rendered
	private static int MAX_WIDTH;
	private static int MAX_HEIGHT;
	
	public static void init(Component map) {
		MAX_WIDTH=map.getWidth();
		MAX_HEIGHT=map.getHeight();
	}
	
	public static int getMaxHeight() {
		return MAX_HEIGHT;
	}
	
	public static int getMaxWidth() {
		return MAX_WIDTH;
	}
	
	/**
	 * Uses java.util.Random to generate a random number between parameters.
	 * Useful for initializations.
	 * @param min
	 * @param max
	 * @return
	 */
	public static int randomInt(int min, int max) {
		Random random=new Random();
		return (random.nextInt(max-min+1)+min);
	}
	
}
