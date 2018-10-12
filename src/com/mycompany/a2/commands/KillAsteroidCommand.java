package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillAsteroidCommand extends Command {
	
	private GameWorld gw;

	public KillAsteroidCommand(GameWorld gw) {
		super("KillAsteroid");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.killAsteroid();
		System.out.println("Asteroid shot.");
	}

}
