package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class KillNPSCommand extends Command {
	
	private GameWorld gw;

	public KillNPSCommand(GameWorld gw) {
		super("Kill NPS");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.killNPS();
		System.out.println("NPS destroyed.");
	}

}
