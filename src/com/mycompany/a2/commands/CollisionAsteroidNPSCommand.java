package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class CollisionAsteroidNPSCommand extends Command {
	
	private GameWorld gw;

	public CollisionAsteroidNPSCommand(GameWorld gw) {
		super("Collide NPS With Asteroid");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.collisionAsteroidNPS();
		System.out.println("Asteroid collided with NPS.");
	}

}
