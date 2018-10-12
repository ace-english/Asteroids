package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends MoveableObject{
	static int MAX_SIZE = 30;
	static int MIN_SIZE = 6;
	
	int size;
	
	public Asteroid(){
		setX(Util.randomInt(0, Util.getMaxWidth()));
		setY(Util.randomInt(0, Util.getMaxHeight()));
		setHeading(Util.randomInt(0, 360));
		setSize(Util.randomInt(MIN_SIZE, MAX_SIZE));
		setSpeed(Util.randomInt(0, Util.MAX_SPEED));
		setColor(ColorUtil.GRAY);
		
	}
	
	public int getSize() {return size;}
	
	/**
	 * Setter checks to make sure size is in acceptable range
	 * @param size
	 */
	private void setSize(int size) {
		if(size>=MIN_SIZE&&size<=MAX_SIZE)
			this.size=size;
		else
			System.err.println("Error setting size to "+size);
	}
	
	public String toString() {
		return "Asteroid: "+ super.toString() + "size="+size+" ";
	}
	
}
