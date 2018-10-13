package com.mycompany.a2;

import java.util.Observable;
import java.util.Vector;


public class GameWorld extends Observable implements IGameWorld{
	

	private GameCollection objectList;
	private int score, lives, time;
	boolean sound;
	
	
	public void init() { 
		score=0;
		time=0;
		lives=3;
		sound=true;
		objectList = new GameCollection();
	}
	
	public GameWorld() {
		init();
	}
	
	/**
	 * Returns the static playerShip
	 * @return
	 */
	public PlayerShip getPS() {
		if(findAll(Util.ObjectType.PlayerShip).isEmpty()) {
			//System.err.println("No PS found");
			return null;
		}
		return PlayerShip.getPS();
	}
	
	/**
	 * Function finds all objects of the corresponding type and
	 * returns them in a vector
	 * @param type
	 * @return
	 */
	public Vector<GameObject> findAll(Util.ObjectType type) {
		Vector<GameObject> subset=new Vector<GameObject>();
		IIterator it = objectList.getIterator();
		GameObject temp;
		while(it.hasNext()) {
			temp=(GameObject) it.getNext();
			switch(type) {
			case PlayerShip:
				if(temp instanceof PlayerShip) {
					subset.add(temp);
				}
				break;
			case Asteroid:
				if(temp instanceof Asteroid) {
					subset.add(temp);
				}
				break;
			case NPSMissile:
				if(temp instanceof NPSMissile) {
					subset.add(temp);
				}
				break;
			case PlayerMissile:
				if(temp instanceof PlayerMissile) {
					subset.add(temp);
				}
				break;
			case NPS:
				if(temp instanceof NPS) {
					subset.add(temp);
				}
				break;
			
			default:
				//System.err.println("No "+type+ " found.");
				break;
			}
		}
		return subset;
	}
	
	/**
	 * Returns a random object from the subset given by findAll()
	 * If none are found, prints an error and returns null.
	 * @param type
	 * @return
	 */
	public GameObject findRandom(Util.ObjectType type) {
		Vector<GameObject> subset=findAll(type);
		if (subset.isEmpty()) {
			System.err.println("Error: no "+type+" found.");
			return null;
		}
		return (GameObject) subset.get(Util.randomInt(0, subset.size()-1));
	}
	
	/**
	 * Creates new object in vector that matches parameter.
	 * Only allows one PlayerShip to exist at a time
	 * @param gameobject
	 */
	public void add(Util.ObjectType type) {
		switch (type) {
		case Asteroid:
			objectList.add(new Asteroid());
			break;
		case NPS:
			NPS nps = new NPS();
			objectList.add(nps);
			break;
		case PlayerShip:
			//verify that we don't already have a PS
			if(findAll(Util.ObjectType.PlayerShip).isEmpty()) {
				objectList.add(PlayerShip.getPS());
			}
			else{
				System.err.println("Error: player ship already exists.");
			}
			break;
		case Station:
			objectList.add(new Station());
			break;
		default:
			System.err.println("Invalid input.");
			return;
		
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	/**
	 * Adds object to vector. Useful for missiles.
	 * @param gameObject
	 * @return 
	 */
	public boolean add(GameObject gameObject) {
		if(gameObject!=null) {
			objectList.add(gameObject);
			return true;
		}
		else {
			return false;
		}
		
	}
	/**
	 * Increment play ship speed by 1, to a maximum of 10
	 */
	public void increaseSpeed(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			ps.setSpeed(ps.getSpeed()+1);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Decrement player ship speed by 1, to a minimum of 0
	 */
	public void decreaseSpeed(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			ps.setSpeed(ps.getSpeed()-1);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Rotate PlayerShip 45 degrees left
	 */
	public void turnLeft(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			ps.turn(Util.Direction.left);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Rotate PlayerShip 45 degrees right
	 */
	public void turnRight(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else{
			ps.turn(Util.Direction.right);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Rotate missileLauncher 45 degrees counterclockwise
	 */
	public void aimLeft(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			((ISteerable) getPS().getMissileLauncher()).turn(Util.Direction.left);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Rotate missileLauncher 45 degrees clockwise
	 */
	public void aimRight(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			((ISteerable) getPS().getMissileLauncher()).turn(Util.Direction.right);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * PS fires a missile from its missileLauncher, which
	 * is added to the game world
	 */
	public void firePS(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			add(getPS().fire());
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	
	}
	/**
	 * NPS fires a missile from its missileLauncher, which
	 * is added to the game world
	 */
	public void fireNPS(){
		NPS nps=(NPS) findRandom(Util.ObjectType.NPS);
		if(nps==null) {
			System.err.println("Error: no NPS exists.");
		}
		else {
			add(nps.fire());
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Reset position to middle.
	 */
	public void hyperspaceJump(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			ps.setX(Util.getMaxWidth()/2);
			ps.setY(Util.getMaxHeight()/2);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Player visits a space station
	 */
	public void restock(){
		PlayerShip ps=getPS();
		if(ps==null) {
			System.err.println("Error: player ship does not yet exist.");
		}
		else {
			getPS().restock();
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Player shoots an asteroid.
	 * Return score increase.
	 */
	private void killTarget(Missile missile, GameObject target){
		if(missile==null) {
			System.err.println("Error: no missilies have been fired.");
		}
		if(target == null) {
			System.err.println("Error: invalid target.");
		}
		if (target!=null&&missile!=null){
			score+=((Asteroid) target).getSize()*10;
			objectList.remove(target);
			objectList.remove(missile);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Player shoots an asteroid.
	 * Return score increase.
	 */
	public void killAsteroid(){
		PlayerMissile missile=(PlayerMissile) findRandom(Util.ObjectType.PlayerMissile);
		Asteroid asteroid=(Asteroid) findRandom(Util.ObjectType.Asteroid);
		killTarget(missile, asteroid);
	}
	/**
	 * Player shoots an NPS.
	 * Returns score increase
	 */
	public void killNPS() {
		PlayerMissile missile=(PlayerMissile) findRandom(Util.ObjectType.PlayerMissile);
		NPS nps=(NPS) findRandom(Util.ObjectType.NPS);
		killTarget(missile, nps);
	}
	/**
	 * Player has been shot by NPS
	 */
	public void playerShot() {
		Missile missile=(Missile) findRandom(Util.ObjectType.NPSMissile);
		if(missile==null) {
			System.err.println("Error: no missilies have been fired.");
		}
		if(getPS()==null)
			System.err.println("Error: player ship does not yet exist.");
		else if(missile!=null) {
			objectList.remove(missile);
			explodePS();
		}
	}
	/**
	 * Player crashes into asteroid
	 */
	public void collisionAsteroid(){
		Asteroid asteroid=(Asteroid) findRandom(Util.ObjectType.Asteroid);
		if(asteroid == null) {
			System.err.println("Error: no asteroids have been found.");
		}
		if(getPS()==null)
			System.err.println("Error: player ship does not yet exist.");
		if (asteroid!=null&&getPS()!=null){
			objectList.remove(asteroid);
			explodePS();
		}
	}
	/**
	 * PS collides with NPS
	 */
	public void collisionNPS(){
		NPS nps=(NPS)findRandom(Util.ObjectType.NPS);
		if(nps == null) {
			System.err.println("Error: no asteroids have been found.");
		}
		if(getPS()==null)
			System.err.println("Error: player ship does not yet exist.");
		if (nps!=null&&getPS()!=null){
			objectList.remove(nps);
			explodePS();
		}
	}
	/**
	 * Two asteroids collide and destroy each other
	 */
	public void asteroidCollision(){
		if(findAll(Util.ObjectType.Asteroid).size()<2) {
			System.err.println("Error: not enough asteroids");
		}
		else {
			Asteroid asteroid1=(Asteroid) findRandom(Util.ObjectType.Asteroid);
			objectList.remove(asteroid1);
			Asteroid asteroid2=(Asteroid) findRandom(Util.ObjectType.Asteroid);
			objectList.remove(asteroid2);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	/**
	 * Asteroid and NPS destroy each other
	 */
	public void collisionAsteroidNPS(){
		Asteroid asteroid=(Asteroid) findRandom(Util.ObjectType.Asteroid);
		NPS nps=(NPS)findRandom(Util.ObjectType.NPS);
		if(nps==null)
			System.err.println("Error: no ships have been found.");
		if(asteroid==null)
			System.err.println("Error: no asteroids have been found.");
		if(asteroid!=null&&nps!=null) {
			objectList.remove(asteroid);
			objectList.remove(nps);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
	}
	
	/**
	 * Outputs the toString from everything in objectList
	 */
	public String printAll() {
		String ret= new String();
		IIterator it=objectList.getIterator();
		while(it.hasNext()) {
			ret+=it.getNext()+"\n";
		}
		return ret;
		
	}
	/**
	 * Increments game clock
	 * Calls the move() function for anything that is moveable.
	 * Removes missiles that are out of fuel
	 */
	public void tick() {
		time++;
		GameObject item;
		for(int i=0; i<objectList.size(); i++) {
			item=objectList.get(i);
			if(item instanceof IMoveable) {
				if(((MoveableObject) objectList.get(i)).move()==false) {	//if move function returns false, destroy it
					objectList.remove(i);
					i--;
				}
			}
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	/**
	 * Player crashes
	 */
	private void explodePS(){
		lives--;
		if(lives<=0) {
			System.out.println("Game Over.");
			//printDisplay();
			System.exit(0);
		}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}

	@Override
	public int getPoints() {
		return score;
	}

	@Override
	public int getLives() {
		return lives;
	}

	@Override
	public boolean getSound() {
		return sound;
	}
	public void setSound(boolean sound) {
		this.sound=sound;
	}

	@Override
	public int getTime() {
		return time;
	}

	@Override
	public int getAmmo() {
		PlayerShip ps=getPS();
		if (ps==null)
			return 0;
		return ps.getMissileCount();
	}
	

	
}
