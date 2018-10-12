package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {

	private Point2D coords;
	private int color;
	
	public double getX(){return coords.getX();}
	public double getY(){return coords.getY();}
	public int getColor() {return color;}
	
	/**
	 * Creates random starting locations for object that do not specify
	 */
	public GameObject() {
		coords=new Point2D(Util.randomInt(0, Util.getMaxWidth()),Util.randomInt(0, Util.getMaxHeight()));
	}

	/**
	 * Checks to make sure x is in acceptable range
	 * @param x
	 */
	public void setX(double x) {
		if(x>=0&&x<=Util.getMaxWidth())
			this.coords.setX(x);
		else
			System.err.print("Error: cannot assign x of "+x);
	}
	
	/**
	 * Checks to make sure y is in acceptable range
	 * @param y
	 */
	public void setY(double y) {
		if(y>=0&&y<=Util.getMaxHeight())
			this.coords.setY(y);
		else
			System.err.print("Error: cannot assign y of "+y);
	}
	
	public void setColor(int color) {
		this.color=color;
	}
	
	public String toString() {
		return "loc="+coords+" color=["+ ColorUtil.red(color)+
				","+ColorUtil.green(color)+
				","+ColorUtil.blue(color)+"] ";
	}
	
	
}
