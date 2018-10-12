package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class Station extends GameObject {
	private int blinkrate;
	private final static int BLINKRATE_MIN=0;
	private final static int BLINKRATE_MAX=4;
	
	public Station(){
		setBlinkrate(Util.randomInt(BLINKRATE_MIN, BLINKRATE_MAX));
		setColor(ColorUtil.rgb(0, 0xb4, 0xff));
		//initialize to a lovely blue
	}
	
	public int getBlinkrate() {return blinkrate;}
	
	/**
	 * Checks to make sure blinkrate it within acceptable range when assigning
	 * @param blinkrate
	 */
	private void setBlinkrate(int blinkrate) {
		if(blinkrate>0 && blinkrate<=BLINKRATE_MAX)
			this.blinkrate=blinkrate;
		else
			System.err.println("Error setting blinkrate to "+blinkrate);
	}
	
	public String toString() {
		return "Station: " + super.toString()+"rate="+getBlinkrate()+" ";
	}
}
