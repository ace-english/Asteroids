package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class RestockCommand extends Command {
	
	private GameWorld gw;

	public RestockCommand(GameWorld gw) {
		super("Fire PS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.restock();
		System.out.println("Ship restocked.");
	}

}
