package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class PlayerShotCommand extends Command {
	
	private GameWorld gw;

	public PlayerShotCommand(GameWorld gw) {
		super("Player Shot");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.playerShot();
		System.out.println("Player ship has been hit.");
	}

}
