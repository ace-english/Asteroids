package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class AddNPSCommand extends Command {
	
	private GameWorld gw;

	public AddNPSCommand(GameWorld gw) {
		super("Add NPS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.add(Util.ObjectType.NPS);
		System.out.println("NPS added.");
	}

}
