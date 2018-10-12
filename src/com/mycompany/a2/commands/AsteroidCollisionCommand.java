package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class AsteroidCollisionCommand extends Command {
	
	private GameWorld gw;

	public AsteroidCollisionCommand(GameWorld gw) {
		super("Two Asteroids Collide");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.asteroidCollision();
		System.out.println("Asteroids destroyed.");
	}

}
