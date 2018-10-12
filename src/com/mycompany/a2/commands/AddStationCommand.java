package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class AddStationCommand extends Command {
	
	private GameWorld gw;

	public AddStationCommand(GameWorld gw) {
		super("Add Station");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.add(Util.ObjectType.Station);
		System.out.println("Station added.");
	}

}
