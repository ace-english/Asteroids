package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class AimRightCommand extends Command {
	
	private GameWorld gw;

	public AimRightCommand(GameWorld gw) {
		super("Aim Right");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.aimRight();
		System.out.println("Missile launcher aimed 45 degrees to the right.");
	}

}
