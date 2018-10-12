package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollisionAsteroidCommand extends Command {
	
	private GameWorld gw;

	public CollisionAsteroidCommand(GameWorld gw) {
		super("Crash Into Asteroid");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.collisionAsteroid();
		System.out.println("Asteroid crashed into.");
	}

}
