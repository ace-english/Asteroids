package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CollisionNPSCommand extends Command {
	
	private GameWorld gw;

	public CollisionNPSCommand(GameWorld gw) {
		super("Asteroid collides with NPS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.collisionNPS();
		System.out.println("Collided with NPS.");
	}

}
