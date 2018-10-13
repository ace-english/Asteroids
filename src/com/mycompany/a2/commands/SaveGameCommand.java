package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;
import com.mycompany.a2.Util;

public class SaveGameCommand extends Command {
	
	private GameWorld gw;

	public SaveGameCommand(GameWorld gw) {
		super("Save");
		this.gw=gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Save command chosen.");
	}

}
