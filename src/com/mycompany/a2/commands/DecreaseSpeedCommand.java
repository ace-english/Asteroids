package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecreaseSpeedCommand extends Command {
	
	private GameWorld gw;

	public DecreaseSpeedCommand(GameWorld gw) {
		super("Decrease Speed");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeed();
		System.out.println("Speed decreased.");
	}

}
