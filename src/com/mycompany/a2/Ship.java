package com.mycompany.a2;

public abstract class Ship extends MoveableObject {
	protected MissileLauncher missileLauncher;
	private int missileCount;
	
	/**
	 * Checks to see if ship can fire a missile.
	 * Returns a new Missile with this ship's heading
	 * Returns null if missile count is less than 0.
	 * @return
	 */
	
	public Missile fire() {
		if(missileCount<=0) {
			System.out.println("Error: out of ammo!");
			return null;
		}
		missileCount--;
		return missileLauncher.fire();
	}
	
	public void setSpeed(int speed) {
		super.setSpeed(speed);
	}
	
	public abstract void restock();

	/**
	 * Returns missileLauncher of ship
	 * @return
	 * */
	public MissileLauncher getMissileLauncher() {
		return missileLauncher;
	}
	 
	
	/**
	 * Verifies argument is 0 or more before assigning to missiles
	 * @param missileCount
	 */
	public void setMissileCount(int missileCount) {
		if(missileCount>0)
			this.missileCount=missileCount;
	}

	public int getMissileCount() {
		return missileCount;
	}
	
	public String toString() {
		return super.toString()+" missiles="+missileCount+" ";
	}
	

}
