package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class FireNPSCommand extends Command {
	
	private GameWorld gw;

	public FireNPSCommand(GameWorld gw) {
		super("Fire NPS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.fireNPS();
		System.out.println("NPS missile fired.");
	}

}
