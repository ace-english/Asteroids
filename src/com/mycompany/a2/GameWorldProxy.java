package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {

	GameWorld gw;
	
	public GameWorldProxy(GameWorld gw) {
		this.gw=gw;
	}
	
	@Override
	public int getPoints() {
		return gw.getPoints();
	}
	@Override
	public int getLives() {
		return gw.getLives();
	}
	@Override
	public boolean getSound() {
		return gw.getSound();
	}
	@Override
	public int getTime() {
		return gw.getTime();
	}
	@Override
	public int getAmmo() {
		return gw.getAmmo();
	}

	@Override
	public String printAll() {
		return gw.printAll();
	}

}
