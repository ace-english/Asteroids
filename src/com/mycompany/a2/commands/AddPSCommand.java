package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class AddPSCommand extends Command {
	
	private GameWorld gw;

	public AddPSCommand(GameWorld gw) {
		super("Add PS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.add(Util.ObjectType.PlayerShip);
		System.out.println("Player ship added.");
	}

}
