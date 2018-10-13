package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AimLeftCommand extends Command {
	
	private GameWorld gw;

	public AimLeftCommand(GameWorld gw) {
		super("Aim Left");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.aimLeft();
		System.out.println("Missile launcher aimed 45 degrees to the left.");
	}

}
